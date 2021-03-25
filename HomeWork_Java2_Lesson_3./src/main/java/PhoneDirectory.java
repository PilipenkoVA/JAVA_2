import java.util.*;

public class PhoneDirectory {

    private Map<String, List<String>> phoneDirectory = new HashMap<>();
    private List<String> phoneNumber;

    public void add (String surname, String phone_number){
        if(phoneDirectory.containsKey(surname)){
            phoneNumber = phoneDirectory.get(surname);
            phoneNumber.add(phone_number);
            phoneDirectory.put(surname,phoneNumber);
        }else{
            phoneNumber = new ArrayList<>();
            phoneNumber.add(phone_number);
            phoneDirectory.put(surname,phoneNumber);
        }
    }
    public List<String> get(String surname){
        return phoneDirectory.get(surname);
    }
}
