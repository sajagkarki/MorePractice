<div><h3>CSRRest</h3></div>

<ol>
<li><b id="svn">svn</b>Source code</li>
<li><b id="ci">cicsr</b>cicsr - Continuous Integration and Continuous Deployment environment.</li>
<li><b id="dev">devcsr</b>devcsr - Development playground.</li>
<li><b id="test">testcsr</b>testcsr - QA tests this environment.</li>
<li id="content">
    <% if (application.getAttribute("messages") != null) {%>
    <%= application.getAttribute("messages")%>
    <% }%>
</li>
</ol>

<script>
    var shouldGetSVN = false;
    function updateVersionSVN(){
        if(!shouldGetSVN){
            shouldGetSVN = true;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    shouldGetSVN = false;
                    var contentElement = document.getElementById("svn");
                    contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                }
            }
            xmlhttp.open("GET", "https://svncsr.pie.tdwilliamson.com:8883/CSRRest/version.txt", true);
            xmlhttp.send();
        }
    }
    setInterval(updateVersionSVN, 3000);
</script>
<script>
    var shouldGetCI = false;
    function updateVersionCI(){
        if(!shouldGetCI){
            shouldGetCI = true;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    shouldGetCI = false;
                    var contentElement = document.getElementById("ci");
                    contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                }
            }
            xmlhttp.open("GET", "http://cicsr.pie.tdwilliamson.com:8888/CSRRest/version.txt", true);
            xmlhttp.send();
        }
    }
    setInterval(getMessages, 3000);
</script>
<script>
    var shouldGetDEV = false;
    function updateVersionDEV(){
        if(!shouldGetDEV){
            shouldGetDEV = true;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    shouldGetDEV = false;
                    var contentElement = document.getElementById("dev");
                    contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                }
            }
            xmlhttp.open("GET", "http://devcsr.pie.tdwilliamson.com:8888/CSRRest/version.txt", true);
            xmlhttp.send();
        }
    }
    setInterval(getMessages, 3000);
</script>
<script>
    var shouldGetTEST = false;
    function updateVersionTEST(){
        if(!shouldGetTEST){
            shouldGetTEST = true;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    shouldGetTEST = false;
                    var contentElement = document.getElementById("test");
                    contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                }
            }
            xmlhttp.open("GET", "http://devtest.pie.tdwilliamson.com:8888/CSRRest/version.txt", true);
            xmlhttp.send();
        }
    }
    setInterval(getMessages, 3000);
</script>
<div>

<p><a href="http://edit.pie.tdwilliamson.com:3000/s/BJQJNDz5r">Customer-Specific Requirements Infrastucture</a> documentation.</p>

<h3>Development</h3>
<ol>
<li>Develop all endpoints using JAX-RS annotations.</li>
<li>All endpoints are served using /rest route. These don't require authentication, which is common for our /rest APIs.</li>
<li>All endpoints are mirrored to  /api routes. These DO require authentication, which is common for our /api APIs (mostly in AWS.)</li>
<li>All authenticated endpoints will use /api routes. /rest route will be removed before code complete.</li>
</ol>

<h3>Authentication</h3>
<p><b>Authentication</b> is the process of validating the identity of the user making a request.</p>
<p>We are performing two phases of authentication.</p>
<p>First, users will need to authenticate to active directory via AuthREST servlet, which will issue them a JWT (more on this later.)</p>
<p>Second, users will authenticate each request to CSRRest by including a header: Authorization bearer TOKEN where token is a JWT.</p>
<p>Here is an example where we can use a valid development JWT to generate a token for an arbitrary user. This works only in development.</p>
<p><a href="http://localhost:8080/CSRRest/api/auth/token/a1001?token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhMDAwMEBURFdJTExJQU1TT04uQ09NIiwibmFtZSI6IkFscGhhIFp1bHUgTW9jayBVc2VyIiwiaWF0IjoxNTE2MjM5MDIyLCJhdWQiOlsiY3NyLnJvbGUuYWRtaW4iLCJjc3Iucm9sZS5sZWFkIiwiY3NyLnJvbGUubGVhZC50ZWFtLmt3IiwiY3NyLnJvbGUubWVtYmVyLnRlYW0ua3ciLCJjc3Iucm9sZS51c2VyIl19.IjTfT8T-WzZK4nsAalQzPRGht0vEDt0N6OM1jTxYm5g3yHOI4HNUWYk__n5XyC8mrhI3y-SXJpmuOH2_WGFQ8md3tD1nivlsxEiTjnbBaBDo0qtLG8HXTYcWevuAYgoZU99BWv_sOVFKeG38jbzB6rsQOQCD0XTUHMrZq-nxUsZykZxDQ0uMEXmQgILvLSnZ6pSJZTD2f8U5uoSOI_3K1NelMibeP2loRh5cIIFKhOGdKd5Mau1uDKdKCNjPPNXJ5aRXlfkPkZ3ogQY4zdvTJu4h3ecCUUOvfjjoSZwT0Ak8BwMLhe8Nm5oZ7aEwz4zfvUxy9cUn16DAKKHldTGclr80eBWXC5Jr4OJen4TjL0cftwyi9NzRFXuFQPkS5QcIiWn0-inCDcTLUx_vn3H89pfBdhwozQx0xQgXShTdP08oUyL1GLUrgCoB3bVJ7p4_EGo0-5b8mP8VzUbX6W4DsvC8_sFXWLpgeBe4LESL3q25YXQSR3dgQ4yveId4LtYZolGCNZhmksgUYv9Lu18PYU9V_-8TWEBJ63tjAMDvBb2Xog7o_DM_HJ0UVlyOAkzb-82EMrkm9jK-Z0ymR10WZ5NnEGr-E_6_BBqv60oNzDxQmaPGFymZxRdXXatYcL8KY1SvwXJMrJ6m9Fn0nI6Lk21Ji0YGFgSz-GwabJWREuI">http://localhost:8080/CSRRest/api/auth/token/a1001?token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhMDAwMEBURFdJTExJQU1TT04uQ09NIiwibmFtZSI6IkFscGhhIFp1bHUgTW9jayBVc2VyIiwiaWF0IjoxNTE2MjM5MDIyLCJhdWQiOlsiY3NyLnJvbGUuYWRtaW4iLCJjc3Iucm9sZS5sZWFkIiwiY3NyLnJvbGUubGVhZC50ZWFtLmt3IiwiY3NyLnJvbGUubWVtYmVyLnRlYW0ua3ciLCJjc3Iucm9sZS51c2VyIl19.IjTfT8T-WzZK4nsAalQzPRGht0vEDt0N6OM1jTxYm5g3yHOI4HNUWYk__n5XyC8mrhI3y-SXJpmuOH2_WGFQ8md3tD1nivlsxEiTjnbBaBDo0qtLG8HXTYcWevuAYgoZU99BWv_sOVFKeG38jbzB6rsQOQCD0XTUHMrZq-nxUsZykZxDQ0uMEXmQgILvLSnZ6pSJZTD2f8U5uoSOI_3K1NelMibeP2loRh5cIIFKhOGdKd5Mau1uDKdKCNjPPNXJ5aRXlfkPkZ3ogQY4zdvTJu4h3ecCUUOvfjjoSZwT0Ak8BwMLhe8Nm5oZ7aEwz4zfvUxy9cUn16DAKKHldTGclr80eBWXC5Jr4OJen4TjL0cftwyi9NzRFXuFQPkS5QcIiWn0-inCDcTLUx_vn3H89pfBdhwozQx0xQgXShTdP08oUyL1GLUrgCoB3bVJ7p4_EGo0-5b8mP8VzUbX6W4DsvC8_sFXWLpgeBe4LESL3q25YXQSR3dgQ4yveId4LtYZolGCNZhmksgUYv9Lu18PYU9V_-8TWEBJ63tjAMDvBb2Xog7o_DM_HJ0UVlyOAkzb-82EMrkm9jK-Z0ymR10WZ5NnEGr-E_6_BBqv60oNzDxQmaPGFymZxRdXXatYcL8KY1SvwXJMrJ6m9Fn0nI6Lk21Ji0YGFgSz-GwabJWREuI</a></p>

<p>The rest of this document is being rewritten to follow the new paradigm, ymmv. - SR</p>
<p>Unauthenticated requests will return an HTTP status 401, counterintuitively called "Unauthorized".</p>
<p>All rest/* routes are protected, requiring Authentication and Authorization.</p>
<p><b>Authorization</b> is the process of ensuring a request is permissible.</p>
<p>Authenticated, but unauthorized, requests will return an HTTP status 403, "Forbidden".</p>
<p>Both are provided by a signed JSON Web Token (JWT) from our Auth service.</p>
<p><a href="api/auth/user">api/auth/user</a> - get user info.</p>
<p><a href="api/auth/token">api/auth/token</a> - request a signed JWT.</p>
<p>TODO SR query parameters are not secure. switch to header.
<p>/api/auth/validate?token=TOKEN</p>
<h3>REST API</h3>
<p><a href="rest/metrics">rest/metrics</a> - Show app metrics.</p>
<p><a href="rest/help">rest/help</a> - Show registered API methods.</p>
<p><a href="rest/help/version">rest/help/version</a> - Shows some static metadata (wasn't implemented.)</p>
<h3>Extra Pages</h3>
<p><a href="version.txt">version.txt</a> - Show svn revision that was used to build this app.</p>
<p><a href="manager/html/">manager/html/ - Tomcat Web Application Manager page</a></p>
</div>

<div>
<h3>Authentication steps</h3>
<ol>
<li>1) Connect via TLS (optional in dev, enforced automatically for test and prod.)</li>
<li>2) Server requires "Authentication: NEGOTIATE" authentication.</li>
<li>2a) Integrated Windows Authentication SPNEGO/GSS-API Kerberos (if available)
<li>2b) Alternatively, server will fallback to prompt for LDAP or BASIC user-password authentication</li>
<li>3) Server loads UserProfile</li>
<li>4) Server generates and returns Json Web Token (JWT) signed (JWS) using RSA, which can be verified by any client via its public key.</li>
</ol>
</div>

<div>
<li>Authorization</li>
<li>
<ol>
<li>1) Connect via TLS (optional in dev, enforced automatically for test/prod.)</li>
<li>2) Client includes header "Authorization: bearer JWS" (optional for /rest, required for enforcing /api endpoints)</li>
<li>3) Server checks JWS vs resource</li>
<li>3a) Server returns 401 Unauthorized if:</li>
<li>3a1) JWS does not include a claim for resource.</li>
<li>3a2) JWS outside window (expired or before use-after-time</li>
<li>3a3) JWS signature isn't validated</li>
<li>5) Server returns 200 with resource if authorized.</li>
</ol>
</li>
</ol>
</div>

<div>
<h3>Authentication Tests</h3>
<p><a href="WEB-INF/web.xml">WEB-INF/web.xml</a></p>
</div>



<div>
Sourced from CSRRest/WebContent/WEB-INF/index.jsp (NOT classes/)
</div>
