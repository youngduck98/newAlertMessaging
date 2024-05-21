package org.example.newalertmessaging.mailService.common.exception;

import org.example.newalertmessaging.mailService.common.domainObject.AnnData;

public class MissingAnnException extends RuntimeException{
    AnnData annData;
    public MissingAnnException(int beforeNum, AnnData annData){
        super("Department: " + annData.getDepartment() + "link: " +
                annData.getSite().getLink() + "missingFrom: " + (beforeNum+1)
                + "missingEnd: " + (annData.getPostNumber() - 1));
        this.annData = annData;
    }
}
