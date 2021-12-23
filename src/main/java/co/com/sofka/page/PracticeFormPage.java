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

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

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

    //Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.png";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "open.png";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileName.png";

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

        click(SELECT_PICTURE_PATCH);
        typeInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH+practiceFormModel.getPicture());
        click(SELECT_OPEN_PATCH);

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
