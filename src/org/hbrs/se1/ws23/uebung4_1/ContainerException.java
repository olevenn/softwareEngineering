package org.hbrs.se1.ws23.uebung4_1;

public class ContainerException extends Exception {
    private String modus;
    private Integer id;
    private ContainerException.ExceptionType type;

    public ContainerException(ContainerException.ExceptionType type  ) {
        this.type = type;
    }

    @Override
    public void printStackTrace() {

        if ( this.type == ContainerException.ExceptionType.DuplicateMember ) {

            System.out.println("Das Member-Objekt mit der ID " + this.id + " ist bereits vorhanden!");

        } else if ( this.type == ContainerException.ExceptionType.InfoCastException ) {

            System.out.println("Das Member-Objekt mit der ID " + this.id + " konnte nicht gecastet werden!");

        }
    }

    public void addID(Integer id) {
        this.id = id;
    }

    public enum ExceptionType {
        InfoCastException, DuplicateMember
    }
}
