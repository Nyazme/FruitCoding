package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    @FXML
    public Button btnBuyApple;
    @FXML
    public Button btnBuyOrange;
    @FXML
    public Button btnBuyBanana;
    @FXML
    public Button btnBuyGrape;
    @FXML
    public Button btnSellApple;
    @FXML
    public Button btnSellOrange;
    @FXML
    public Button btnSellBanana;
    @FXML
    public Button btnSellGrape;
    @FXML
    public Text priceApple;
    @FXML
    public Text priceOrange;
    @FXML
    public Text priceBanana;
    @FXML
    public Text priceGrape;
    @FXML
    public Text boxApple;
    @FXML
    public Text boxOrange;
    @FXML
    public Text boxBanana;
    @FXML
    public Text boxGrape;
    @FXML
    public Text boxSellApple;
    @FXML
    public Text boxSellOrange;
    @FXML
    public Text boxSellBanana;
    @FXML
    public Text boxSellGrape;
    @FXML
    public Text cashOwned;
    @FXML
    public Text timer;

    public int playerCash = 100;
    int high = 10;
    int low = 1;
    Random diceRoll = new Random();
    int randomApple = diceRoll.nextInt(high);
    int randomOrange = diceRoll.nextInt(high);
    int randomBanana = diceRoll.nextInt(high);
    int randomGrape = diceRoll.nextInt(high);
    private int counterApple = 0;
    private int counterOrange = 0;
    private int counterBanana = 0;
    private int counterGrape = 0;

    public int countTimer = 16;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateBoxes();
        setUpClock();
    }
    public void  updateBoxes(){

        priceApple.setText("Price: $" + randomApple);
        priceOrange.setText("Price: $" + randomOrange);
        priceBanana.setText("Price: $" + randomBanana);
        priceGrape.setText("Price: $" + randomGrape);

        boxApple.setText("Apples Owned: " + counterApple);
        boxOrange.setText("Oranges Owned: " + counterOrange);
        boxBanana.setText("Bananas Owned: " + counterBanana);
        boxGrape.setText("Grapes Owned: " + counterGrape);

        cashOwned.setText("Cash Available: $" + playerCash);
        //boxSellApple.setText("Averages: $" + (counterApple/playerCash));
    }
    public void clickBuyApple(ActionEvent actionEvent) {
        if (playerCash > randomApple) {
            playerCash = playerCash - randomApple;
            counterApple++;
            updateBoxes();
        }
    }

    public void clickBuyOrange(ActionEvent actionEvent){
        if (playerCash > randomOrange) {
            playerCash = playerCash - randomOrange;
            counterOrange++;
            updateBoxes();
        }
    }
    public void clickBuyBanana(ActionEvent actionEvent){
        if (playerCash > randomBanana) {
            playerCash = playerCash - randomBanana;
            counterBanana++;
            updateBoxes();
        }
    }
    public void clickBuyGrape(ActionEvent actionEvent){
        if (playerCash > randomGrape) {
            playerCash = playerCash - randomGrape;
            counterGrape++;
            updateBoxes();
        }
    }
    public void clickSellApple(ActionEvent actionEvent){
        if (counterApple > 0){
            playerCash = playerCash + randomApple;
            counterApple--;
            updateBoxes();
        }
    }
    public void clickSellOrange(ActionEvent actionEvent) {
        if (counterOrange > 0) {
            playerCash = playerCash + randomOrange;
            counterOrange--;
            updateBoxes();
        }
    }

    public void clickSellBanana(ActionEvent actionEvent){
    if (counterBanana > 0){
        playerCash = playerCash + randomBanana;
        counterBanana--;
        updateBoxes();
    }
}
    public void clickSellGrape(ActionEvent actionEvent){
        if (counterGrape > 0){
            playerCash = playerCash + randomGrape;
            counterGrape--;
            updateBoxes();
        }
    }
    public void setUpClock(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countTimer--;
                String stringTimer = String.valueOf(countTimer);
                timer.setText(stringTimer);
                if (countTimer == 0){
                    countTimer = 16;
                    randomApple = diceRoll.nextInt(high);
                    randomOrange = diceRoll.nextInt(high);
                    randomBanana = diceRoll.nextInt(high);
                    randomGrape = diceRoll.nextInt(high);
                    updateBoxes();
                }
            }
        };
        Timer timey = new Timer();
        timey.schedule(task,1000L,1000L);
    }

}
