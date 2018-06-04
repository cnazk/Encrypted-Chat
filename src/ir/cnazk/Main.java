package ir.cnazk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();
        primaryStage.setTitle("Hello World");
        String s = "(#%^#$∑©∑ƒ∂™£®";
        RSA rsa = RSA.generate();
        ArrayList<Long> encrypted = rsa.publicKey.encrypt(s);
        String a = "";

        for (Long ch : encrypted) {
            a = a + (char) ch.intValue();
        }



        Text text = new Text(a);
        String decrypted = rsa.privateKey.decrypt(encrypted);
        Text de = new Text(decrypted);
        grid.add(text, 0, 0);
        grid.add(de, 0, 1);
        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show();
    }

    private boolean isPrime(long n) {
        for (long i = n - 1; i > Math.sqrt(n) + 1; i--)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
