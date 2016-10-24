package controller;

/**
 * Created by Brandon on 10/3/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

public class EditProfileScreenController {

    private MainFXApplication screen;
    private User user;

    @FXML
    private TextField newName;

    @FXML
    private TextField newAddr;

    @FXML
    private TextField newEmail;

    @FXML
    private TextField newPass;

    @FXML
    private TextField confirmPass;

    @FXML
    private Label passError;

    @FXML
    /**
     * Action taken when user clicks the Confirm button.
     */
    private void handleConfirm() {
        String name = newName.getCharacters().toString();
        String addr = newAddr.getCharacters().toString();
        String email = newEmail.getCharacters().toString();
        String pass = newPass.getCharacters().toString();
        String confirm = confirmPass.getCharacters().toString();

        if (!pass.equals("") && pass.equals(confirm)) {
            user.setPassword(pass);
        } else if (!pass.equals(confirm)) {
            passError.setVisible(true);
            return;
        }
        if (!name.equals("")) {
            user.setName(name);
        }
        if (!addr.equals("")) {
            user.setAddress(addr);
        }
        if (!email.equals("")) {
            user.setEmail(email);
        }

        screen.init(1);
    }

    @FXML
    /**
     * Action taken when user clicks the Cancel buttom
     */
    private void handleCancel() {
        screen.init(1);
    }

    /**
     * Sets the main application that this controller pertains to.
     * @param app App using the controller.
     */
    public void setMain(MainFXApplication app) {
        screen = app;
    }

    /**
     * Loads the user editing profile.
     * @param user User trying to edit profile.
     */
    public void loadUser(User user) {
        this.user = user;
    }
}
