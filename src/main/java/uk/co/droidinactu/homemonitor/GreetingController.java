/**
 * Copyright© Andy Aspell-Clark - All rights reserved$
 */

package uk.co.droidinactu.homemonitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public final class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return new Greeting(this.counter.incrementAndGet(),
                String.format(GreetingController.TEMPLATE, name));
    }
}
