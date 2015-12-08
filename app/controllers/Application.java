package controllers;

import models.Person;
import play.*;
import play.data.Form;
import play.mvc.*;

import com.avaje.ebean.Model;
import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("This is only a test."));
    }

    public Result addPerson(){
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    public Result getPersons(){
        List<Person> persons = new Model.Finder<String, Person>(Person.class).all();
        return ok(toJson(persons));
    }

}
