package bankingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class BankAcctGUI extends JFrame {
    private JTextField txtCustomerID, txtSSN, txtLastName, txtFirstName, txtAddress, txtCity, txtZip, txtPhone, txtAccountNumber, txtTransactionAmount, txtTransactionDate;
    private JComboBox<String> cmbState;
    private JRadioButton rdoChecking, rdoSavings, rdoDeposit, rdoWithdraw;
    private JButton btnAddCustomer, btnDisplay, btnPerformTransaction, btnClear;
    private JTextArea txtOutput;
    private List<Customer> customers = new ArrayList<>();
    private JLabel lblStatus;

    public BankAcctGUI() {
        setTitle("Bank Account Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // MAIN PANEL (LEFT: Customer & Account, RIGHT: Transaction & Buttons)
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        lblStatus = new JLabel(" ");
        lblStatus.setForeground(Color.RED);
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStatus, BorderLayout.NORTH);

        //  GROUP 1: Customer & Account Info (LEFT)
        JPanel customerPanel = new JPanel(new GridLayout(12, 2, 5, 5));

        customerPanel.add(new JLabel("Customer ID:"));
        txtCustomerID = new JTextField();
        customerPanel.add(txtCustomerID);

        customerPanel.add(new JLabel("SSN:"));
        txtSSN = new JTextField();
        customerPanel.add(txtSSN);

        customerPanel.add(new JLabel("Last Name:"));
        txtLastName = new JTextField();
        customerPanel.add(txtLastName);

        customerPanel.add(new JLabel("First Name:"));
        txtFirstName = new JTextField();
        customerPanel.add(txtFirstName);

        customerPanel.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        customerPanel.add(txtAddress);

        customerPanel.add(new JLabel("City:"));
        txtCity = new JTextField();
        customerPanel.add(txtCity);

        customerPanel.add(new JLabel("State:"));
        cmbState = new JComboBox<>(new String[]{"CA", "NY", "TX", "FL", "IL"});
        customerPanel.add(cmbState);

        customerPanel.add(new JLabel("ZIP:"));
        txtZip = new JTextField();
        customerPanel.add(txtZip);

        customerPanel.add(new JLabel("Phone:"));
        txtPhone = new JTextField();
        customerPanel.add(txtPhone);

        customerPanel.add(new JLabel("Account Number:"));
        txtAccountNumber = new JTextField();
        customerPanel.add(txtAccountNumber);

        customerPanel.add(new JLabel("Account Type:"));
        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup accountGroup = new ButtonGroup();
        rdoChecking = new JRadioButton("Checking");
        rdoSavings = new JRadioButton("Savings");
        accountGroup.add(rdoChecking);
        accountGroup.add(rdoSavings);
        accountPanel.add(rdoChecking);
        accountPanel.add(rdoSavings);
        customerPanel.add(accountPanel);

        // Last row: Buttons
        btnAddCustomer = new JButton("Add New Customer and Account");
        btnDisplay = new JButton("Display Customer and Account Data");
        customerPanel.add(btnAddCustomer);
        customerPanel.add(btnDisplay);

        // GROUP 2: Transaction Info
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel transactionPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        transactionPanel.add(new JLabel("Transaction Date (MM/DD/YYYY):"));
        txtTransactionDate = new JTextField();
        transactionPanel.add(txtTransactionDate);

        transactionPanel.add(new JLabel("Transaction Amount:"));
        txtTransactionAmount = new JTextField();
        transactionPanel.add(txtTransactionAmount);

        transactionPanel.add(new JLabel("Transaction Type:"));
        JPanel transactionTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup transactionGroup = new ButtonGroup();
        rdoDeposit = new JRadioButton("Deposit");
        rdoWithdraw = new JRadioButton("Withdraw");
        transactionGroup.add(rdoDeposit);
        transactionGroup.add(rdoWithdraw);
        transactionTypePanel.add(rdoDeposit);
        transactionTypePanel.add(rdoWithdraw);
        transactionPanel.add(transactionTypePanel);

        transactionPanel.add(new JLabel("")); // Empty left column
        JPanel performTransactionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPerformTransaction = new JButton("Perform Transaction");
        performTransactionPanel.add(btnPerformTransaction);
        transactionPanel.add(performTransactionPanel);

        rightPanel.add(transactionPanel, BorderLayout.NORTH);

        // GROUP 3: Clear Button
        JPanel clearPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnClear = new JButton("Clear");
        clearPanel.add(btnClear);
        rightPanel.add(clearPanel, BorderLayout.SOUTH);

        // OUTPUT AREA
        txtOutput = new JTextArea(8, 50);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        // ADD COMPONENTS TO FRAME
        mainPanel.add(customerPanel);
        mainPanel.add(rightPanel);
        add(mainPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // ADD BUTTON LISTENERS
        btnAddCustomer.addActionListener(new AddCustomerListener());
        btnPerformTransaction.addActionListener(new PerformTransactionListener());
        btnDisplay.addActionListener(new DisplayCustomerListener());
        btnClear.addActionListener(e -> clearFields());

        setVisible(true);
    }

    // EVENT LISTENERS
    private class AddCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // VALIDATE CUSTOMER INPUTS
            if (txtCustomerID.getText().isEmpty() || txtSSN.getText().isEmpty() || txtLastName.getText().isEmpty()
                    || txtFirstName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtCity.getText().isEmpty()
                    || txtZip.getText().isEmpty() || txtPhone.getText().isEmpty() || txtAccountNumber.getText().isEmpty()) {
                lblStatus.setText("Error: Please fill in all fields.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            
            if (!DataEntry.checkMaxStringLen(txtCustomerID.getText(), 5)) {
                lblStatus.setText("Error: Customer ID must be 5 characters or less.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            if (!DataEntry.checkExactStringLen(txtSSN.getText(), 9) || !DataEntry.checkNumString(txtSSN.getText())) {
                lblStatus.setText("Error: SSN must be exactly 9 digits.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!DataEntry.checkMaxStringLen(txtLastName.getText(), 20)) {
                lblStatus.setText("Error: Last name cannot exceed 20 characters.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!DataEntry.checkMaxStringLen(txtFirstName.getText(), 15)) {
                lblStatus.setText("Error: First name cannot exceed 15 characters.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!DataEntry.checkMaxStringLen(txtAddress.getText(), 20)) {
                lblStatus.setText("Error: Address cannot exceed 20 characters.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!DataEntry.checkMaxStringLen(txtCity.getText(), 20)) {
                lblStatus.setText("Error: City cannot exceed 20 characters.");
                lblStatus.setForeground(Color.RED);
                return;
            }      
            if (!DataEntry.checkExactStringLen(txtZip.getText(), 5) || !DataEntry.checkNumString(txtZip.getText())) {
                lblStatus.setText("Error: ZIP code must be exactly 5 numeric digits.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            if (!DataEntry.checkExactStringLen(txtPhone.getText(), 10) || !DataEntry.checkNumString(txtPhone.getText())) {
                lblStatus.setText("Error: Phone number must be exactly 10 numeric digits.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!DataEntry.checkMaxStringLen(txtAccountNumber.getText(), 5)) {
                lblStatus.setText("Error: Account number cannot exceed 5 characters.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            if (!rdoChecking.isSelected() && !rdoSavings.isSelected()) {
                lblStatus.setText("Error: Please select an account type.");
                lblStatus.setForeground(Color.RED);
                return;
            }
            // CREATE CUSTOMER & ACCOUNT
            Customer newCustomer = new Customer(txtCustomerID.getText(), txtSSN.getText(), txtLastName.getText(),
                    txtFirstName.getText(), txtAddress.getText(), txtCity.getText(), cmbState.getSelectedItem().toString(),
                    txtZip.getText(), txtPhone.getText());

            String accountType = rdoChecking.isSelected() ? "CHK" : "SAV";
            Account newAccount = accountType.equals("CHK") ? new CheckingAccount(txtAccountNumber.getText()) :
                    new SavingsAccount(txtAccountNumber.getText());

            newCustomer.getAccounts().add(newAccount);
            customers.add(newCustomer);

            lblStatus.setText("Customer and Account Added Successfully!");
            lblStatus.setForeground(Color.GREEN);
        }
    }
    
    private class DisplayCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String customerID = txtCustomerID.getText().trim();

            if (customerID.isEmpty()) {
                lblStatus.setText("Error: Please enter a Customer ID to search.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            Customer foundCustomer = null;
            for (Customer customer : customers) {
                if (customer.getCustomer_id().equals(customerID)) {
                    foundCustomer = customer;
                    break;
                }
            }

            if (foundCustomer == null) {
                lblStatus.setText("Error: Customer ID not found.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            // Retrieve customer data
            String customerData = String.format(
                    "Customer Data:\n" +
                    "ID: %-10s \nSSN: %-10s\n" +
                    "Name: %-10s %-10s\n" +
                    "Address: %-20s\n" +
                    "City: %-10s \nState: %-2s \nZip: %-5s\n" +
                    "Phone: %-10s\n",
                    foundCustomer.getCustomer_id(),
                    foundCustomer.getCustomer_ssn(),
                    foundCustomer.getCustomer_firstname(),
                    foundCustomer.getCustomer_lastname(),
                    foundCustomer.getCustomer_street(),
                    foundCustomer.getCustomer_city(),
                    foundCustomer.getCustomer_state(),
                    foundCustomer.getCustomer_zip(),
                    foundCustomer.getCustomer_phone()
            );

            // Retrieve account data
            StringBuilder accountData = new StringBuilder("\nAccount Data:\n");
            if (foundCustomer.getAccounts().isEmpty()) {
                accountData.append("No accounts found.\n");
            } else {
                for (Account acct : foundCustomer.getAccounts()) {
                    accountData.append(String.format(
                            "Account Number: %-5s Type: %-3s\n" +
                            "Service Fee: $%-5.2f Interest Rate: %-4.2f%%\n" +
                            "Overdraft Fee: $%-5.2f Balance: $%-7.2f\n",
                            acct.getAccount_number(),
                            acct.getAccount_type(),
                            acct.getService_fee(),
                            acct.getInterest_rate(),
                            acct.getOverdraft_fee(),
                            acct.getBalance()
                    ));
                }
            }

            // Display in output field
            txtOutput.setText(customerData + accountData.toString());
        }
    }

    private class PerformTransactionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String customerID = txtCustomerID.getText().trim();
            String transactionDate = txtTransactionDate.getText().trim();
            double amount;
            double interestEarned = 0.0;
            String transactionType = rdoDeposit.isSelected() ? "DEP" : "WTH";

            // Validate Transaction Date (MM/DD/YYYY)
            if (!DataEntry.checkDate(transactionDate)) {
                lblStatus.setText("Error: Invalid date format. Please enter in MM/DD/YYYY format.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            // Validate Transaction Amount (Must be a Positive Number)
            try {
                amount = Double.parseDouble(txtTransactionAmount.getText().trim());
                if (amount <= 0) {
                    lblStatus.setText("Error: Transaction amount must be greater than zero.");
                    lblStatus.setForeground(Color.RED);
                    return;
                }
            } catch (NumberFormatException ex) {
                lblStatus.setText("Error: Invalid transaction amount. Please enter a valid positive number.");
                lblStatus.setForeground(Color.RED);
                return;
            }

            // Find the Customer
            for (Customer customer : customers) {
                if (customer.getCustomer_id().equals(customerID)) {
                    for (Account account : customer.getAccounts()) {
                        
                        double previousBalance = account.getBalance();
                        double serviceFee = account.getService_fee();
                        double overdraftFee = 0.0;
                        double interestRate = account.getInterest_rate();
                        boolean isOverdraft = false;
                        boolean isInsufficientFunds = false;
                        
                     // Calculate and Apply Interest (Only if balance is positive)
                        if (!isInsufficientFunds && account.getBalance() > 0) {                            
                            interestEarned = account.getBalance() * (interestRate/100);
                        }
                        
                        // Process Transaction
                        if (transactionType.equals("DEP")) {
                            account.deposit(amount);
                        } else {
                            if (account instanceof SavingsAccount && amount + serviceFee > previousBalance) {
                                isInsufficientFunds = true;
                            } else {
                                if (account instanceof CheckingAccount && amount + serviceFee > previousBalance) {
                                    isOverdraft = true;
                                    overdraftFee = account.getOverdraft_fee();
                                }
                                account.withdrawal(amount);
                            }
                        }
                        
                        // Display Transaction Result
                        if (isInsufficientFunds) {
                            lblStatus.setText("Error: Insufficient funds. Transaction cancelled.");
                            lblStatus.setForeground(Color.RED);
                        } else {
                        	lblStatus.setText("Transaction Successful!");
                        	lblStatus.setForeground(Color.GREEN);
                            txtOutput.setText("Customer ID: " + customer.getCustomer_id() + "\n"
                                    + "Account Number: " + account.getAccount_number() + "\n"
                                    + "Transaction Date: " + transactionDate + "\n"
                                    + "Transaction Type: " + transactionType + "\n"
                                    + "Transaction Amount: $" + amount + "\n"
                                    + "Service Fee: $" + serviceFee + "\n"
                                    + (isOverdraft ? "Overdraft Fee: $" + overdraftFee + "\n" : "")
                                    + "Interest Earned: " + interestEarned + "\n"
                                    + "New Balance: $" + account.getBalance());
                        }
                        return;
                    }
                }
            }
            lblStatus.setText("Transaction Failed: Customer Not Found!");
            lblStatus.setForeground(Color.RED);
        }
    }


    private void clearFields() {
        txtCustomerID.setText("");
        txtSSN.setText("");
        txtLastName.setText("");
        txtFirstName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtZip.setText("");
        txtPhone.setText("");
        txtAccountNumber.setText("");
        txtTransactionAmount.setText("");
        txtTransactionDate.setText("");
        txtOutput.setText("");
    }

    public static void main(String[] args) {
        new BankAcctGUI();
    }
}
