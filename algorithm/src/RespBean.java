public class RespBean {
    private int code;
    private String message;

    public RespBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespBean(){}

    public RespBean error(){
        return new RespBean(500,null);
    }
    public RespBean error(int code,String message){
        return new RespBean(code,message);
    }
    public RespBean success(){
        return new RespBean(200,null);
    }
    public RespBean success(int code,String message){
        return new RespBean(code,message);
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
