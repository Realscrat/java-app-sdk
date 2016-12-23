/*
 * The MIT License
 *
 * Copyright (c) 2016 The Things Network
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.thethingsnetwork.samples.account;

import java.net.URI;
import org.thethingsnetwork.account.util.HttpRequest;

/**
 *
 * @author Romain Cambier
 */
public class App {

    public static void main(String[] args) throws Exception {
        Config cfg = new Config();
        cfg.cliendId = System.getenv("cliendId");
        cfg.clientSecret = System.getenv("clientSecret");
        cfg.redirect = (System.getenv("redirect") == null) ? null : new URI(System.getenv("redirect"));
        cfg.applicationId = System.getenv("applicationId");
        cfg.applicationKey = System.getenv("applicationKey");

        System.out.println("Starting AuthorizationCodeAsync");
        AuthorizationCodeAsync.run(cfg);
        System.out.println("Starting AuthorizationCodeSync");
        AuthorizationCodeSync.run(cfg);
        System.out.println("Starting ApplicationPasswordAsync");
        ApplicationPasswordAsync.run(cfg);
        System.out.println("Starting ApplicationPasswordSync");
        ApplicationPasswordSync.run(cfg);
        
        HttpRequest.shutdown();

    }

    public static class Config {

        public String cliendId;
        public String clientSecret;
        //for authorization code
        public URI redirect;
        //for app password
        public String applicationId;
        public String applicationKey;

    }
}
