package sv.com.asi.manejadores;

import sv.com.asi.entidades.EmpleadoEspecialidad;
import sv.com.asi.manejadores.util.JsfUtil;
import sv.com.asi.manejadores.util.PaginationHelper;
import sv.com.asi.controladores.EmpleadoEspecialidadFacade;

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

@Named("empleadoEspecialidadController")
@SessionScoped
public class EmpleadoEspecialidadController implements Serializable {

    private EmpleadoEspecialidad current;
    private DataModel items = null;
    @EJB
    private sv.com.asi.controladores.EmpleadoEspecialidadFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EmpleadoEspecialidadController() {
    }

    public EmpleadoEspecialidad getSelected() {
        if (current == null) {
            current = new EmpleadoEspecialidad();
            current.setEmpleadoEspecialidadPK(new sv.com.asi.entidades.EmpleadoEspecialidadPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private EmpleadoEspecialidadFacade getFacade() {
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
        current = (EmpleadoEspecialidad) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new EmpleadoEspecialidad();
        current.setEmpleadoEspecialidadPK(new sv.com.asi.entidades.EmpleadoEspecialidadPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getEmpleadoEspecialidadPK().setIdEmpleado(current.getEmpleado().getIdEmpleado());
            current.getEmpleadoEspecialidadPK().setIdEspecialidad(current.getEspcialidad().getIdEspecialidad());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("EmpleadoEspecialidadCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/lenguajes").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EmpleadoEspecialidad) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getEmpleadoEspecialidadPK().setIdEmpleado(current.getEmpleado().getIdEmpleado());
            current.getEmpleadoEspecialidadPK().setIdEspecialidad(current.getEspcialidad().getIdEspecialidad());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("EmpleadoEspecialidadUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/lenguajes").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (EmpleadoEspecialidad) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/lenguajes").getString("EmpleadoEspecialidadDeleted"));
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

    public EmpleadoEspecialidad getEmpleadoEspecialidad(sv.com.asi.entidades.EmpleadoEspecialidadPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = EmpleadoEspecialidad.class)
    public static class EmpleadoEspecialidadControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpleadoEspecialidadController controller = (EmpleadoEspecialidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empleadoEspecialidadController");
            return controller.getEmpleadoEspecialidad(getKey(value));
        }

        sv.com.asi.entidades.EmpleadoEspecialidadPK getKey(String value) {
            sv.com.asi.entidades.EmpleadoEspecialidadPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new sv.com.asi.entidades.EmpleadoEspecialidadPK();
            key.setIdEspecialidad(Integer.parseInt(values[0]));
            key.setIdEmpleado(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(sv.com.asi.entidades.EmpleadoEspecialidadPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEspecialidad());
            sb.append(SEPARATOR);
            sb.append(value.getIdEmpleado());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EmpleadoEspecialidad) {
                EmpleadoEspecialidad o = (EmpleadoEspecialidad) object;
                return getStringKey(o.getEmpleadoEspecialidadPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EmpleadoEspecialidad.class.getName());
            }
        }

    }

}
