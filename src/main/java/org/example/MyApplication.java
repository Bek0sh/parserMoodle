package org.example;

import org.example.entities.User;
import org.example.entities.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Scanner;

public class MyApplication {
    Users users = new Users();
    private final ChromeDriver driver;
    Scanner sc = new Scanner(System.in);

    public MyApplication(ChromeDriver driver) {
        this.driver = driver;
    }

    public void start() {

        System.out.println("Enter your barcode");
        String barcode = sc.next();
        System.out.println("Enter your password");
        String accPassword = sc.next();

        try {
            driver.get("https://moodle.astanait.edu.kz/login/index.php");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(2000);
            auth(barcode, accPassword);
            calculus2(wait);
            discrete(wait);
            intro2(wait);
            oop(wait);
            physEd(wait);
            politics(wait);
            foreignLang(wait);
            users.print();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void auth(String barcode, String accPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String OPEN_ID_BUTTON = "//*[@id=\"region-main\"]/div/div[2]/div/div/div/div/div/div[2]/div[4]/div/a";
        WebElement openIdButton = driver.findElement(By.xpath(OPEN_ID_BUTTON));
        openIdButton.click();


        String USERNAME_FIELD = "//*[@id=\"i0116\"]";
        WebElement username = (wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(
                                (By.xpath(USERNAME_FIELD)))));
        username.sendKeys(barcode + "@astanait.edu.kz", Keys.ENTER);

        String PASSWORD_FIELD = "passwd";
        WebElement password = (wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(
                                (By.name(PASSWORD_FIELD)))));
        password.sendKeys(accPassword, Keys.ENTER);


        String CONFIRM_BUTTON = "//*[@id=\"idSIButton9\"]";
        WebElement buttonYes = driver.findElement(By.xpath(CONFIRM_BUTTON));
        buttonYes.click();
    }

    public void calculus2(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav/ul/li[6]/a";
        subjects(wait, subjectButton);
        info();
    }

    public void discrete(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[7]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    public void intro2(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[8]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    public void oop(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[9]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    public void physEd(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[10]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    public void politics(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[11]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    public void foreignLang(WebDriverWait wait) {
        String subjectButton = "//*[@id=\"nav-drawer\"]/nav[2]/ul/li[12]/a/div/div/span[2]";
        subjects(wait, subjectButton);
        info();
    }

    private void subjects(WebDriverWait wait,String subjectButton) {
        WebElement subject = (wait
                .until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath(subjectButton)
                        )));
        subject.click();

        String gradesButton = "//*[@id=\"nav-drawer\"]/nav[1]/ul/li[4]/a/div/div/span[2]";
        WebElement grades = (wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(gradesButton)
                )));
        grades.click();
    }

    public void info() {
        String midTermRes = "//*[@id=\"region-main\"]/div/table/tbody/tr[3]/td[4]";
        String endTermRes = "//*[@id=\"region-main\"]/div/table/tbody/tr[4]/td[4]";
        String finalExam = "//*[@id=\"region-main\"]/div/table/tbody/tr[6]/td[4]";
        String attendance = "//*[@id=\"region-main\"]/div/table/tbody/tr[8]/td[4]";
        String subName = "//*[@id=\"page-header\"]/div/div/div/div[1]/div[1]/div/div/h1";
        WebElement subject = driver.findElement(By.xpath(subName));
        String nameOfSubject = subject.getText();

        WebElement midterm = driver.findElement(By.xpath(midTermRes));
        String midTerm = midterm.getText();

        WebElement endterm = driver.findElement(By.xpath(endTermRes));
        String endTerm = endterm.getText();

        WebElement finalexam = driver.findElement(By.xpath(finalExam));
        String finalExamRes = finalexam.getText();

        WebElement _attendance = driver.findElement(By.xpath(attendance));
        String attendance_calculus = _attendance.getText();

        users.add(new User(nameOfSubject,attendance_calculus ,midTerm, endTerm, finalExamRes));
    }
}
