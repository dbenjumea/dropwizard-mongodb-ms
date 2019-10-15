package com.dbenjumea.api;

import com.google.common.base.Objects;

public class Response {

    /** The message.*/
    private String message;

    /** Constructor.*/
    public Response() {
    }
//getters & setters
//hashcode, equals and toString methods


    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Response other = (Response) obj;
        return Objects.equal(this.message, other.message);
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                '}';
    }
}
