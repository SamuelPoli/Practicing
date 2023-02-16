package Java.SocketsSam;

import java.io.Serializable;

public class UsuariosConectados implements Serializable{
    private String nick;
    private String ip;
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}
