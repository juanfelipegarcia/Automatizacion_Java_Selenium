package co.com.sofka.page;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.common.CommonActionOnpages;
import co.com.sofka.util.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonActionOnpages{
    private final PracticeFormModel practiceFormModel;

    //For input test cases
    private final By name = By.id("firstName");
    private final By lasName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]");
    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]");
    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]");
    private final By mobile = By.id("userNumber");
    private final By date = By.id("dateOfBirthInput");
    private final By subjects = By.id("subjectsInput");
    private final By hobbieSport = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]");
    private final By hobbieRead = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]");
    private final By hobbieMusic = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]");
    private final By address = By.id("currentAddress");
    private final By picture = By.id("uploadPicture");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submitButton = By.id("submit");

    // For validations
    private final By assertionStudenName = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By assertionEmail = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]");
    private final By assertionGender = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By assertionMobile = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");
    private final By assertionBirthDate = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]");
    private final By assertionSubjects = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]");
    private final By assertionHobbies = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]");
    private final By assertionPicture = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]");
    private final By assertionAddres = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]");
    private final By assertionStateCity = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]");

    public PracticeFormPage(PracticeFormModel practiceFormModel, WebDriver webDriver) {
        super(webDriver);
        this.practiceFormModel = practiceFormModel;
    }

    // Funtions
    public void fillMandatoryFields(){

        clearText(name);
        typeInto(name,practiceFormModel.getName());
        clearText(lasName);
        typeInto(lasName, practiceFormModel.getLastName());


        switch (practiceFormModel.getGender()){
            case FEMALE:
                click(genderFemale);
                break;
            case MALE:
                click(genderMale);
                break;
            case OTHER:
                click(genderOther);
                break;
        }

        clearText(mobile);
        typeInto(mobile, practiceFormModel.getMobile());

        scrollDown();

        findElement(submitButton);
        click(submitButton);

    }

    public void fillAllFileds(){

        clearText(name);
        typeInto(name,practiceFormModel.getName());
        clearText(lasName);
        typeInto(lasName, practiceFormModel.getLastName());
        clearText(email);
        typeInto(email, practiceFormModel.getEmail());

        switch (practiceFormModel.getGender()){
            case FEMALE:
                click(genderFemale);
                break;
            case MALE:
                click(genderMale);
                break;
            case OTHER:
                click(genderOther);
                break;
        }

        clearText(mobile);
        typeInto(mobile, practiceFormModel.getMobile());

        click(date);
        By selectYear = By.xpath("//option[.='"+practiceFormModel.getYear()+"']");
        click(selectYear);
        By selectMont = By.xpath("//option[.='"+practiceFormModel.getMonth()+"']");
        click(selectMont);
        By day = By.xpath("//div[contains(@aria-label,'"+practiceFormModel.getDay()+"') and contains(@aria-label,'"+practiceFormModel.getMonth()+"')]");
        click(day);

        scrollDown();

        List listSubjects = practiceFormModel.getSubject();
        for (int i = 0; i < listSubjects.size(); i++) {
            typeInto(subjects, (String) listSubjects.get(i));
            enter(subjects);
        }

        List listHobbies = practiceFormModel.getHobbies();
        for (int x = 0; x < listHobbies.size(); x++){
            switch ((Hobbies) listHobbies.get(x)){
                case SPORTS:
                    click(hobbieSport);
                    break;
                case READING:
                    click(hobbieRead);
                    break;
                case MUSIC:
                    click(hobbieMusic);
                    break;
            }
        }

        scrollDown();

        addFile(picture, practiceFormModel.getPath()+practiceFormModel.getPicture());

        typeInto(address, practiceFormModel.getCurrentAddress());

        typeInto(state, practiceFormModel.getState());
        enter(state);

        typeInto(city, practiceFormModel.getCity());
        enter(city);
        scrollDown();

        findElement(submitButton);
        click(submitButton);
    }


    public List<String> isRegistrationDoneMandatory(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudenName).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());

        return submitedFormResult;
    }

    public List<String> isRegistrationDoneAll(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudenName).trim());
        submitedFormResult.add(getText(assertionEmail).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());
        submitedFormResult.add(getText(assertionBirthDate).trim());
        submitedFormResult.add(getText(assertionSubjects).trim());
        submitedFormResult.add(getText(assertionHobbies).trim());
        submitedFormResult.add(getText(assertionPicture).trim());
        submitedFormResult.add(getText(assertionAddres).trim());
        submitedFormResult.add(getText(assertionStateCity).trim());

        return submitedFormResult;
    }
}
