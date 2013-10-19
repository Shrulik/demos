package controllers;

import models.Quote;
import play.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import views.html.*;
import views.html.index;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }


    @Transactional(readOnly = true)
    public static Result quotes() {
        return ok(Json.toJson(Quote.findAll()));
    }


    @Transactional
    public static Result addQuote() {
        Form<Quote> quoteForm = form(Quote.class).bindFromRequest();
        if (quoteForm.hasErrors()){
            return badRequest(quoteForm.errorsAsJson());
        }

        Quote quote = quoteForm.get();
        quote.save();
        return ok(Json.toJson(quote));
    }

}
