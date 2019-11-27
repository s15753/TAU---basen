package s15753.tau.labone.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s15753.tau.labone.domain.Pool;
import s15753.tau.labone.service.PoolStorage;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
public class PoolApi {

    @Autowired
    PoolStorage poolStorage;

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/pool/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pool read(@PathVariable("id") Integer id) throws SQLException {
        return poolStorage.read(id);
    }

    @GetMapping(value = "/pools", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Pool> readAll(@RequestParam(value = "filter", required = false) String f)
            throws SQLException {
        return poolStorage.readAll();
    }

    @RequestMapping(value = "/pool",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Pool create(@RequestBody Pool p) throws SQLException {
        if (poolStorage.create(p) < 1) return null;
        return p;
    }

    @RequestMapping(value = "/pool/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(@PathVariable("id") Integer id) throws SQLException {
        return poolStorage.delete(id);
    }

    @RequestMapping(value = "/pools", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteAll() throws SQLException {
        return poolStorage.deleteAll();
    }

    @PutMapping (value = "/pool/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateFramework(@PathVariable("id") Integer id,@RequestBody Pool p ) throws SQLException {
        return poolStorage.update(id, p);
    }
}
