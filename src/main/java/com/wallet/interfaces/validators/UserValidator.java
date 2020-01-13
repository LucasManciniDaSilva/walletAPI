package com.wallet.interfaces.validators;

import com.wallet.dto.UserDTO;
import com.wallet.entity.Users;
import com.wallet.exception.MessageError;
import com.wallet.exception.MessageError.ApiError;
import com.wallet.interfaces.Messages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    private final MessageError messageError;


    public UserValidator(MessageError messageError) {
        this.messageError = messageError;
    }

    public List<ApiError> validateValues(UserDTO dto){
        List<ApiError> errors = new ArrayList<>();


<<<<<<< HEAD
            if(StringUtils.isBlank(dto.getName())){
=======
        if(StringUtils.isBlank(dto.getName())){
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
                errors.add(this.messageError.create(Messages.NAME_NOT_INFORMED));
        }
        if(StringUtils.isBlank(dto.getEmail())){
            errors.add(this.messageError.create(Messages.EMAIL_NOT_INFORMED));
        }

        if(StringUtils.isBlank(dto.getPassword())){
            errors.add(this.messageError.create(Messages.PASSWORD_NOT_INFORMED));
        }
        return errors;
    }


}
