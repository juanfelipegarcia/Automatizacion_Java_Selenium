package co.com.sofka.page;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.common.CommonActionOnpages;
import co.com.sofka.util.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonActionOnpages{
    private final PracticeFormModel practiceFormModel;

    //For input test cases




    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement email;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]")
    private WebElement genderMale;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]")
    private WebElement genderFemale;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]")
    private WebElement genderOther;

    @CacheLookup
    @FindBy(id = "userNumber")
    private WebElement mobile;

    @CacheLookup
    @FindBy(id = "dateOfBirthInput")
    private WebElement date;

    @CacheLookup
    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]")
    private WebElement hobbieSport;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]")
    private WebElement hobbieRead;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]")
    private WebElement hobbieMusic;

    @CacheLookup
    @FindBy(id = "currentAddress")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "uploadPicture")
    private WebElement picture;

    @CacheLookup
    @FindBy(id = "react-select-3-input")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "react-select-4-input")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement submitButton;



    //private final By name = By.id("firstName");
    //private final By lastName = By.id("lastName");
    //private final By email = By.id("userEmail");
//    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]");
//    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]");
//    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]");
//    private final By mobile = By.id("userNumber");
//    private final By date = By.id("dateOfBirthInput");
//    private final By subjects = By.id("subjectsInput");
//    private final By hobbieSport = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]");
//    private final By hobbieRead = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]");
//    private final By hobbieMusic = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]");
//    private final By address = By.id("currentAddress");
//    private final By picture = By.id("uploadPicture");
//    private final By state = By.id("react-select-3-input");
//    private final By city = By.id("react-select-4-input");
//    private final By submitButton = By.id("submit");



    // For validations

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    private WebElement assertionStudenName;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    private WebElement assertionEmail;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    private WebElement assertionGender;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    private WebElement assertionMobile;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    private WebElement assertionBirthDate;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    private WebElement assertionSubjects;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    private WebElement assertionHobbies;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    private WebElement assertionPicture;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    private WebElement assertionAddres;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    private WebElement assertionStateCity;
/*
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
    */
    //Constructor
    public PracticeFormPage(PracticeFormModel practiceFormModel, WebDriver webDriver) {
        super(webDriver);
        this.practiceFormModel = practiceFormModel;
        PageFactory.initElements(webDriver, this);
    }

    // Funtions
    public void fillMandatoryFields(){

        clearText(name);
        typeInto(name,practiceFormModel.getName());
        clearText(lastName);
        typeInto(lastName, practiceFormModel.getLastName());

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

        click(submitButton);

    }

    public void fillAllFileds(){

        clearText(name);
        typeInto(name,practiceFormModel.getName());
        clearText(lastName);
        typeInto(lastName, practiceFormModel.getLastName());
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
