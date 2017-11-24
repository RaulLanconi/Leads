/*
 * AbstractDTO.java
 *
 * Classe DTO (Data Transfer Object) genérica.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dto;

import java.util.List;

/**
 * Classe AbstractDTO, representa uma Data Transfer Object genérica que pode ser usada por qualquer
 * outra DTO filha.
 *
 * @author Raul Lançoni de Paula
 *
 */
public abstract class AbstractDTO<T> {

    private boolean ok;
    private String 	message;
    private T		object;
    private List<T> listObject;

    /**
     * Construtor AbstractDTO(boolean pOk, String pMessage)
     * da classe AbstractDTO.
     *
     * @param pOk
     * @param pMessage
     */
    public AbstractDTO(boolean pOk, String pMessage) {

        super();
        setOk(pOk);
        setMessage(pMessage);

    }

    /**
     * Construtor AbstractDTO(boolean pOk, String pMessage, T pObject)
     * da classe AbstractDTO.
     *
     * @param pOk
     * @param pMessage
     * @param pObject
     */
    public AbstractDTO(boolean pOk, String pMessage, T pObject) {

        super();
        setOk(pOk);
        setMessage(pMessage);
        setObject(pObject);

    }

    /**
     * Construtor AbstractDTO(boolean pOk, String pMessage, List<T> pListObject)
     * da classe AbstractDTO.
     *
     * @param pOk
     * @param pMessage
     * @param pListObject
     */
    public AbstractDTO(boolean pOk, String pMessage, List<T> pListObject) {

        super();
        setOk(pOk);
        setMessage(pMessage);
        setListObject(pListObject);

    }

    /**
     * @return the ok
     */
    public boolean isOk() {
        return ok;
    }
    /**
     * @param pOk the ok to set
     */
    public void setOk(boolean pOk) {
        this.ok = pOk;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param pMessage the message to set
     */
    public void setMessage(String pMessage) {
        this.message = pMessage;
    }

    /**
     * @return the object
     */
    public T getObject() {
        return object;
    }
    /**
     * @param pObject the object to set
     */
    public void setObject(T pObject) {
        this.object = pObject;
    }

    /**
     * @return the listObject
     */
    public List<T> getListObject() {
        return listObject;
    }
    /**
     * @param pListObject the listObject to set
     */
    public void setListObject(List<T> pListObject) {
        this.listObject = pListObject;
    }

}