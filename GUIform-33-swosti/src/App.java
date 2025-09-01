import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame f=new JFrame();
        JTextField nameField;
        JTextArea addressArea;
        JTextField emailField;
        JRadioButton maleButton;
        JRadioButton femaleButton;
        JComboBox<String> counrtyComboBox;
        JCheckBox hobbyReading;
        JCheckBox hobbyTravelling;
        JCheckBox hobbySports;
        JButton submitButton;
        f.setTitle("User form");  

        //create the components
        JLabel nameLabel=new JLabel("Name:");   
        nameLabel.setBounds(20,20,100,25);
        nameField=new JTextField();
        nameField.setBounds(140,20,200,25);
        f.add(nameLabel);
        f.add(nameField); 

        JLabel addressLabel=new JLabel("Address");
        addressLabel.setBounds(20,60,100,25);
        addressArea= new JTextArea();
        addressArea.setBounds(140,60,200,75);
        f.add(addressLabel);
        f.add(addressArea);

        JLabel emailLabel= new JLabel("Email:");
        emailLabel.setBounds(20,150,100,25);
        emailField= new JTextField();
        emailField.setBounds(140,150,200,25);
        f.add(emailLabel);
        f.add(emailField);

        JLabel genderLabel= new JLabel("Gender:");
        genderLabel.setBounds(20,190,100,25);
        maleButton= new JRadioButton("Male");
        maleButton.setBounds(140,190,100,25);
        femaleButton= new JRadioButton("Female:");
        femaleButton.setBounds(240, 190, 100, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        f.add(genderLabel);
        f.add(maleButton);
        f.add(femaleButton);

        JLabel countryLabel=new JLabel("Country:");
        countryLabel.setBounds(20,230,100,25); 
        String[] countries ={"USA","Canada","UK","Australia","Other"};
        counrtyComboBox= new JComboBox<>(countries);
        counrtyComboBox.setBounds(140, 230, 200, 25);
        f.add(countryLabel);
        f.add(counrtyComboBox);

        JLabel hobbiesLabel = new JLabel("Hobbies:");
        hobbiesLabel.setBounds(20, 270, 100, 25);
        hobbyReading = new JCheckBox("Reading");
        hobbyReading.setBounds(140,270,100,25);
        hobbyTravelling= new JCheckBox("Travelling");
        hobbyTravelling.setBounds(140,300,100,25);
        hobbySports= new JCheckBox("Sports");
        hobbySports.setBounds(140, 330, 100, 25);
        f.add(hobbiesLabel);
        f.add(hobbyReading);
        f.add(hobbyTravelling);
        f.add(hobbySports);

        submitButton= new JButton("Submit");
        submitButton.setBounds(140,300,100,25);
        f.add(submitButton);
      
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}