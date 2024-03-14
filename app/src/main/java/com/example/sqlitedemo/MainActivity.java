package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitedemo.data.DatabaseHandler;
import com.example.sqlitedemo.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nameField;
    EditText phoneNumberField;

    Button addContactButton;
    Button getContactButton;
    TextView contacts;

    EditText idUpdateField;
    EditText nameUpdateField;
    EditText phoneNumberUpdateField;

    Button updateContactButton;
    EditText idDeleteField;
    Button deleteContactButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = (EditText) findViewById(R.id.name);
        phoneNumberField = (EditText) findViewById(R.id.phone_number);
        addContactButton = (Button) findViewById(R.id.add_contact);
        getContactButton = (Button) findViewById(R.id.get_contact);
        contacts = (TextView) findViewById(R.id.contacts);
        idUpdateField = (EditText) findViewById(R.id.id_update);
        nameUpdateField = (EditText) findViewById(R.id.name_update);
        phoneNumberUpdateField = (EditText) findViewById(R.id.phone_number_update);
        updateContactButton = (Button) findViewById(R.id.update_button);
        idDeleteField = (EditText) findViewById(R.id.id_delete);
        deleteContactButton = (Button) findViewById(R.id.delete_button);
        DatabaseHandler handler = new DatabaseHandler(MainActivity.this);


        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Name field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phone_number = phoneNumberField.getText().toString();
                if (phone_number.equals("")) {
                    Toast.makeText(MainActivity.this, "Phone Number field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact newContact = new Contact();
                newContact.setName(name);
                newContact.setPhoneNumber(phone_number);

                handler.addContact(newContact);
                nameField.setText("");
                phoneNumberField.setText("");
                Toast.makeText(MainActivity.this, "Add contact successfully", Toast.LENGTH_SHORT).show();
            }
        });

        getContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayInfo = "";
                List<Contact> contactList = handler.getAllContacts();

                for (Contact contact: contactList) {
                    displayInfo += contact.toString();
                }
                contacts.setText(displayInfo);
            }
        });

        updateContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idUpdateField.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(MainActivity.this, "Id field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = nameUpdateField.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Name field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phone_number = phoneNumberUpdateField.getText().toString();
                if (phone_number.equals("")) {
                    Toast.makeText(MainActivity.this, "Phone Number field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact newContact = new Contact();
                newContact.setId(Integer.valueOf(id));
                newContact.setName(name);
                newContact.setPhoneNumber(phone_number);

                handler.updateContact(newContact);
                idUpdateField.setText("");
                nameUpdateField.setText("");
                phoneNumberUpdateField.setText("");
                Toast.makeText(MainActivity.this, "Contact update successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        deleteContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idDeleteField.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(MainActivity.this, "Id field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                handler.deleteContact(id);
                Toast.makeText(MainActivity.this, "Delete contact successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}