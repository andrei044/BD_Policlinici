import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppView2 appView2=new AppView2();
        App app=new App("jdbc:mysql://localhost/policlinica");
        AppController2 appController2=new AppController2(appView2,app);
    }
}