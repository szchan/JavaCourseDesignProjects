public class ResponseData {
    private String resultCode;
    private String resultMessage;
    private String username;
    private String password;

    public String getResultCode(){
        return resultCode;
    }

    public void setResultCode(String resultCode){
        this.resultCode = resultCode;
    }

    public String getResultMessage(){
        return resultMessage;
    }

    public void setResultMessage(String resultMessage){
        this.resultMessage = resultMessage;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

//    @ResponseBody
//    @RequestMapping(value="/server",method = RequestMethod.POST)

}
