package ro.fii.javaserverfaces.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "assignedExamsValidator")
public class AssignedExamsValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String assignedExams = (String) value;
        if (!assignedExams.matches("[0-9]+(,[0-9]+)*")) {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(context), new FacesMessage("Bad format"));
        }
    }
}
