package sv.com.asi.manejadores;

import sv.com.asi.entidades.ConsultaMedicamento;
import sv.com.asi.manejadores.util.JsfUtil;
import sv.com.asi.manejadores.util.PaginationHelper;
import sv.com.asi.controladores.ConsultaMedicamentoFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("consultaMedicamentoController")
@SessionScoped
public class ConsultaMedicamentoController implements Serializable {

    private ConsultaMedicamento current;
    private DataModel items = null;
    @EJB
    private sv.com.asi.controladores.ConsultaMedicamentoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ConsultaMedicamentoController() {
    }

    public ConsultaMedicamento getSelected() {
        if (current == null) {
            current = new ConsultaMedicamento();
            current.setConsultaMedicamentoPK(new sv.com.asi.entidades.ConsultaMedicamentoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ConsultaMedicamentoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (ConsultaMedicamento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ConsultaMedicamento();
        current.setConsultaMedicamentoPK(new sv.com.asi.entidades.ConsultaMedicamentoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getConsultaMedicamentoPK().setIdConsulta(current.getConsulta().getIdConsulta());
            current.getConsultaMedicamentoPK().setIdMedicamento(current.getMedicamento().getIdMedicamento());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("ConsultaMedicamentoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/lenguajes").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ConsultaMedicamento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getConsultaMedicamentoPK().setIdConsulta(current.getConsulta().getIdConsulta());
            current.getConsultaMedicamentoPK().setIdMedicamento(current.getMedicamento().getIdMedicamento());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("ConsultaMedicamentoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/lenguajes").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ConsultaMedicamento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("ConsultaMedicamentoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/lenguajes").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public ConsultaMedicamento getConsultaMedicamento(sv.com.asi.entidades.ConsultaMedicamentoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ConsultaMedicamento.class)
    public static class ConsultaMedicamentoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConsultaMedicamentoController controller = (ConsultaMedicamentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "consultaMedicamentoController");
            return controller.getConsultaMedicamento(getKey(value));
        }

        sv.com.asi.entidades.ConsultaMedicamentoPK getKey(String value) {
            sv.com.asi.entidades.ConsultaMedicamentoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new sv.com.asi.entidades.ConsultaMedicamentoPK();
            key.setIdConsulta(Integer.parseInt(values[0]));
            key.setIdMedicamento(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(sv.com.asi.entidades.ConsultaMedicamentoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdConsulta());
            sb.append(SEPARATOR);
            sb.append(value.getIdMedicamento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ConsultaMedicamento) {
                ConsultaMedicamento o = (ConsultaMedicamento) object;
                return getStringKey(o.getConsultaMedicamentoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ConsultaMedicamento.class.getName());
            }
        }

    }

}
