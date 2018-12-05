package main.java.com.transportanalysis.response;

public final class ResponseMessage {

    public String status;
    public String message;

    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseMessage createMessage(String status, String message){
        return new ResponseMessage(status, message);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
