package ro.fii.javaserverfaces.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import java.util.Date;

@FacesValidator(value = "examStartingTimeValidator")
public class ExamStartingTimeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        Date startingTime = (Date) value;
        Date now = new Date();
        if (startingTime.before(now)) {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(context), new FacesMessage("Bad starting time"));
        }
    }
}
