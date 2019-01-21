//
//  ViewController.swift
//  AddressDataBase
//
//  Created by Upma  Sharma on 2018-07-17.
//  Copyright © 2018 Upma  Sharma. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    //created the outlets for the textfields and label
    
    @IBOutlet weak var txtName: UITextField!
    
    @IBOutlet weak var txtAddress: UITextField!
    
    @IBOutlet weak var txtPhone: UITextField!
    
    @IBOutlet weak var lblMessage: UILabel!
    
    //create an empty array of contacts. Initalized with 0 elements. CALLS CLASS Contact
    public var arrContacts: [Contact] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func btnAdd(_ sender: UIButton) {
        
        //stack auxContact variable (btnAdd) --> create object on Heap, mame, address, phone
        //local variable inside btn :data type declared after :
        //this is equvalent Contact auxContact c1 = new auxContact() c# comparative
        //we are in the stack the object auxContact
        //when var can be nil the datatype can have ?, field is optional
        //! is for unwrapping
       
        var auxContact: Contact = Contact()
        
        //this field may contain nill unwrapping
        //these come from the UI
        auxContact.name = txtName.text!
        auxContact.address = txtAddress.text!
        auxContact.phone = txtPhone.text!
        
        arrContacts.append(auxContact)
        
    }
    
    @IBAction func btnSearch(_ sender: UIButton) {
        //created a variable, boolean value is initally false
        var isFound: Bool = false
        var nameToSearch: String = ""
        nameToSearch = txtName.text!
        txtAddress.text = ""
        txtPhone.text = ""
        //range operator i = 0 to i = 9
        for i in 0..<arrContacts.count
        {
            if arrContacts[i].name == nameToSearch
                {
                   txtAddress.text = arrContacts[i].address
                   txtPhone.text = arrContacts[i].phone
                   lblMessage.text = "CONTACT FOUND"
                   //return
                    isFound = true
                    break
                }
            /*else
                {
                  lblMessage.text = "CONTACT NOT FOUND"
                } */
        }
        //either EO Loop, or element found
        if isFound == true
        {
            lblMessage.text = "Contact FOUND"
        }
        else
            {
                lblMessage.text = "Contact not found"
            }
    
    }
}
