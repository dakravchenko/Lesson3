package com.daniil;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubWikiTest {
    /*Ответ на первое задание
      Может быть ситуация, когда эти два локатора найдут разные элмементы.
      $("h1 div") этот локатор ищет первый вложенный div внутри h1 не только первого уровня вложенности,
      но и первый div всех последующих вложенностей
      $("h1").$("div") означает, что первый div будет искаться исключительно среди вложенных элементов
      внутри h1 только непосредственно на первом уровне вложенности
    */
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize ="1920x1080";
    }
    @Test
    void checkSoftAssertion(){
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byText("Soft assertions")).shouldBe(visible);
        $("#wiki-content").$(byText("Soft assertions")).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
