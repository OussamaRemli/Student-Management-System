import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.Statement;
import database.config;
import java.sql.SQLException;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import java.sql.ResultSet;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.print.PrinterJob;
import javafx.print.Printer;


 public class App extends Application{

    //le link de css 
    String css=this.getClass().getResource("style.css").toExternalForm();
    
    // la forme d'inscription (scène 1)
    Label title = new Label("INSCRIPTION DES ETUDIANTS"); 
    Label firstnameLabel = new Label("Firstname :");
    TextField firstname = new TextField();
    Label lastnameLabel = new Label("Lastname :");
    TextField lastname = new TextField();
    Label idlabel  = new Label("CNE :");
    TextField id = new TextField();
    Label emailLabel = new Label("Email :");
    TextField email = new TextField();


    // Tableview liste des étudiant (scène 2) 
    TableView<Person> table = new TableView<>();
    TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
    TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
    TableColumn<Person, String> cneCol = new TableColumn<>("CNE");
    TableColumn<Person, String> emailCol = new TableColumn<>("Email");
    
    Label cnef1 = new Label("entrez le CNE ");
    TextField cnef = new TextField();
    
    // forme scène 3
    Label fname = new Label("Firstname : ");
    TextField fname1 = new TextField();
    Label lmane = new Label("Lastname :");
    TextField lname1 = new TextField();
    Label Ccne = new Label("CNE :");
    TextField Ccne1 = new TextField();
    Label eemail = new Label("Email :");
    TextField pemail = new TextField();


    @Override
    public void start(Stage primarystage){

        
        // boutton du 1ère scène
        Button list = new Button("Voir liste des étudiant");
        Button Add =new Button("Ajouter l'étudiant");
        
        //événement sur les buttons 
        Add.setOnAction(event->insertdata());


        // mise en page du 1ère scène
        HBox hbox = new HBox();
        hbox.getChildren().addAll(Add,list);
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinWidth(200);
        gridPane.setPrefWidth(400);
        gridPane.setMinHeight(100);
        gridPane.setPrefHeight(250);
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.add(firstnameLabel, 0, 1);
        gridPane.add(firstname, 1, 1);
        gridPane.add(lastnameLabel, 0, 2);
        gridPane.add(lastname, 1, 2);
        gridPane.add(idlabel, 0, 3);
        gridPane.add(id, 1, 3);
        gridPane.add(emailLabel, 0, 4);
        gridPane.add(email, 1, 4);        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(gridPane,hbox);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(40));
        // fin de mise en page 


       // stage et scene1 
        Scene scene1 = new Scene(vbox, 500, 300);
        scene1.getStylesheets().add(css);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
      // fin stage et scene

//------------------------------------------------------------------------------------------------------------

      // scene 2 
      //table view
      firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
      lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
      cneCol.setCellValueFactory(new PropertyValueFactory<>("CNE"));
      emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
      table.getColumns().addAll(firstNameCol, lastNameCol, cneCol, emailCol);
      // style 
      firstNameCol.getStyleClass().add("first-name-column");
      lastNameCol.getStyleClass().add("last-name-column");
      cneCol.getStyleClass().add("cne-column");
      emailCol.getStyleClass().add("email-column");
        Button pré =new Button("précédent");
        Button pro = new Button ("voir profil");

    
        // mise en page du 2ème page
        VBox vbox1 =new VBox();
        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(cnef,pro);
        hbox3.setAlignment(Pos.CENTER);

        hbox3.setSpacing(20);
        vbox1.getChildren().addAll(table,cnef1,hbox3,pré);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        vbox1.setPadding(new Insets(10));
        
        // évènement sur button précédent
        pré.setOnAction(event -> stage.setScene(scene1));

        //scene 2 "liste des étudiant" 
        Scene scene2 = new Scene(vbox1,500,300);
        scene2.getStylesheets().add(css);            
    
        // événement sur boutton  "voir liste des étudiant"
        list.setOnAction(event -> {stage.setScene(scene2);  loadData();});

       // scène 3 

       Button pré1 = new Button("précédent");
       Button mise = new Button("mettre à jour");
       Button del = new Button("Supprimer");
       Button print = new Button("imprimer");

       //mise en page de scene 3
       HBox hbox4 =new HBox();
       hbox4.getChildren().addAll(pré1,mise,del,print);
       hbox4.setSpacing(10);
       hbox4.setAlignment(Pos.CENTER);
       GridPane gridPane1 = new GridPane();
       gridPane1.setHgap(10);  
       gridPane1.setVgap(10);
       gridPane1.setMinWidth(200);
       gridPane1.setPrefWidth(400);
       gridPane1.setMinHeight(100);
       gridPane1.setPrefHeight(250);
       gridPane1.setAlignment(Pos.CENTER);
       gridPane1.add(fname, 0, 0);
       gridPane1.add(fname1, 1, 0);
       gridPane1.add(lmane, 0, 1);
       gridPane1.add(lname1, 1, 1);
       gridPane1.add(Ccne, 0, 2);
       gridPane1.add(Ccne1, 1, 2);
       gridPane1.add(eemail, 0, 3);
       gridPane1.add(pemail, 1, 3);
       VBox vbox3 =new VBox();
       vbox3.getChildren().addAll(gridPane1,hbox4);
       vbox3.setSpacing(10);
       vbox3.setPadding(new  Insets(40));

       Scene scene3 = new Scene(vbox3,500,300);
       scene3.getStylesheets().add(css);
       pro.setOnAction(event -> { loadprofil();
        if (loadprofil()) {
            stage.setScene(scene3);
        }
       });
            pré1.setOnAction(event->{stage.setScene(scene2); loadData();});
        del.setOnAction(event->{supprimer();stage.setScene(scene2);loadData();});
        mise.setOnAction(event->{update(); stage.setScene(scene2);});
        print.setOnAction(event->imprimerDonnees(fname1.getText(), lname1.getText(), Ccne1.getText(), pemail.getText()));

}
//print
private void imprimerDonnees(String fname, String lname, String ccne, String email) {
    Printer printer = Printer.getDefaultPrinter();
    PrinterJob printerJob = PrinterJob.createPrinterJob(printer);
    if (printerJob != null) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, new Label("Fiche d'étudiant")); // Ajout de l'en-tête
        gridPane.addRow(1, new Label("Nom:"), new Label(fname));
        gridPane.addRow(2, new Label("Prénom:"), new Label(lname));
        gridPane.addRow(3, new Label("CCNE:"), new Label(ccne));
        gridPane.addRow(4, new Label("Email:"), new Label(email));

        boolean imprime = printerJob.printPage(gridPane);

        if (imprime) {
            printerJob.endJob();
        } else {
            System.out.println("Impression annulée.");
        }
    } else {
        System.out.println("Impossible de créer une tâche d'impression.");
    }
}

private void supprimer() {
    String idd = Ccne1.getText();

    try (Connection connection = new config().connect(); Statement statement = connection.createStatement()) {
        String query = "DELETE FROM etudiant WHERE identifiant = '" + idd + "'";
        int rowsAffected = statement.executeUpdate(query);
        if (rowsAffected > 0) {
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("L'étudiant a été supprimé avec succès !");
            successAlert.showAndWait();
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression : " + e.getMessage());
    }
}

private Boolean loadprofil() {
    String idd = cnef.getText();

    try (Connection connection = new config().connect();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT firstname, lastname, identifiant, email FROM etudiant WHERE identifiant = '" + idd + "'")) {
        if (result.next()) {
            fname1.setText(result.getString("firstname"));
            lname1.setText(result.getString("lastname"));
            Ccne1.setText(result.getString("identifiant"));
            pemail.setText(result.getString("email"));
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Profil introuvable");
            alert.setHeaderText(null);
            alert.setContentText("L'étudiant n'existe pas.");
            alert.showAndWait();
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors du chargement des données : " + e.getMessage());
    }

    return false; 
}

// méthode de mise à jour
private void update() {
    try (Connection connection = new config().connect(); Statement statement = connection.createStatement()) {
        String f = fname1.getText();
        String l = lname1.getText();
        String c = Ccne1.getText();
        String e = pemail.getText();
        String query = "UPDATE etudiant SET firstname = '" + f + "', lastname = '" + l + "', email = '" + e + "' WHERE identifiant = '" + c + "' ";
        int rowsAffected = statement.executeUpdate(query);

        if (rowsAffected > 0) {
            // Affichage du message de succès
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Succès");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Les informations de l'étudiant ont été modifiées avec succès !");
            successAlert.showAndWait();

            loadData();
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour : " + e.getMessage());
    }
}

// méthode de selection des données 
private void loadData() {
    try (Connection connection = new config().connect();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, identifiant, email FROM etudiant")) {

        ObservableList<Person> personList = FXCollections.observableArrayList();

        while (resultSet.next()) {
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String identifiant = resultSet.getString("identifiant");
            String email = resultSet.getString("email");
            Person person = new Person(firstName, lastName, identifiant, email);
            personList.add(person);
        }
        table.setItems(personList);
    } catch (SQLException e) {
        System.out.println("Erreur  : " + e.getMessage());
    }
}

// méthode d'insertion des données
private void insertdata() {
    String fname = firstname.getText();
    String lname = lastname.getText();
    String idd = id.getText();
    String eemail = email.getText();
    
    if (!isValidEmail(eemail)) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Adresse e-mail invalide !");
        alert.showAndWait();
        return; 
    }
    
    try (Connection connection = new config().connect(); Statement statement = connection.createStatement()) {
        // Vérifier l'unicité de l'identifiant
        ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiant WHERE identifiant = '" + idd + "'");
        if (resultSet.next()) {
            // L'identifiant existe déjà
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("L'identifiant existe déjà !");
            alert.showAndWait();
            return;
        }
        
        String query = "INSERT INTO etudiant (firstname, lastname, identifiant, email) VALUES ('" + fname + "', '" + lname + "', '" + idd + "',  '" + eemail + "')";
        statement.executeUpdate(query);
        System.out.println("Insertion réussie !");
        
        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Succès");
        successAlert.setHeaderText(null);
        successAlert.setContentText("L'étudiant a été enregistré avec succès !");
        successAlert.showAndWait();
        
        loadData();        
        firstname.clear();
        lastname.clear();
        id.clear();
        email.clear();
    } catch (SQLException e) {
        System.out.println("Erreur: " + e.getMessage());
    }
}


// vérifier que l'email est correcte 
private boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return email.matches(emailRegex);
}



//class personn
public static class Person {
    private String firstName;
    private String lastName;
    private String CNE;
    private String email;
    public Person(String firstName, String lastName, String CNE, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNE = CNE;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public static void main(String[] args){
    launch(args);
}
}

 