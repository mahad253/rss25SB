package fr.univrouen.rss25SB.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import fr.univrouen.rss25SB.model.TestRSS;
import fr.univrouen.rss25SB.model.Item;

@RestController
public class GetController {

    @GetMapping("/resume")
    public String getListRSSinXML() {
        return "Envoi de la liste des flux RSS";
    }

    @GetMapping("/guid")
    public String getRSSinXML(@RequestParam(value = "guid") String texte) {
        return "Détail du flux RSS demandé : " + texte;
    }

    @GetMapping("/test")
    public String testRSS(@RequestParam(value = "nb") String guid,
                          @RequestParam(value = "search") String titre) {
        return "Test :\n" +
                "guid = " + guid + "\n" +
                "titre = " + titre;
    }

    @RequestMapping(
            value = "/testpost",
            method = RequestMethod.POST,
            consumes = "application/xml"
    )
    public String postTest(@RequestBody String flux) {
        return "<result><response>Message reçu :</response>" + flux + "</result>";
    }

    @PostMapping(value = "/postrss", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String postRSS() {
        TestRSS rss = new TestRSS();
        return rss.loadFileXML();
    }

    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Item getXML() {
        return new Item("12345678", "Test item", "2022-05-01T11:22:33");
    }

    @PostMapping(value = "/postitem", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Item postItem(@RequestBody Item item) {
        System.out.println("Item reçu : " + item); // Pour affichage console
        return item;
    }
}
