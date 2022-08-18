<template>
  <div>
    <body>
      <link
        rel="stylesheet"
        href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
      />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
      <link
        href="https://fonts.googleapis.com/css?family=Shadows+Into+Light|Raleway"
        rel="stylesheet"
        type="text/css"
      />
      <div class="col-md-4 col-sm-6 col-xs-12">
          <ul class="social-icons">
            <li>
              <a class="linkedin" href="https://www.linkedin.com/in/aman-welderufael-5b03a2209/"><i class="fa fa-linkedin"></i></a>
            </li>
            <li>
              <a class="linkedin" href="https://www.linkedin.com/in/justin-ranly/"><i class="fa fa-linkedin"></i></a>
            </li>
            <li>
              <a class="linkedin" href="https://www.linkedin.com/in/robertsiefert/"><i class="fa fa-linkedin"></i></a>
            </li>
            <li>
              <a class="linkedin" href="https://www.linkedin.com/in/betelhem-hagos/"><i class="fa fa-linkedin"></i></a>
            </li>
          </ul>
        </div>

      <section class="introduction">
        <div class="starcontainer">
          <h2>About us</h2>
          <i class="fa fa-star fa-2x"></i>
          <i class="star"></i>
        </div>
        <p>
          This site was created by Aman Welderufael, Robert J. Siefert, Betelhem
          Halgos, and Justin Ranly.
        </p>

        <p>
          We are junior developers from Tech Elevator in Columbus, Ohio. Over
          the last 14 weeks we have learned the concepts and principals of
          software development, with a focus on Java and learning how to develop
          dynamic web-based software systems using the Java programming language
          and platform with 700+ hours of lecture and application including:
        </p>
      
        
        <p>
          Object-Oriented Programming: Java - Web Application Development: HTML,
          CSS, JavaScript, Spring Boot, Vue.js - Database Programming: JDBC,
          Table Design, SQL, PostgreSQL, E/R diagrams - Development Tools and
          Techniques: Agile, Unit Testing (JUnit), Integration Testing, Unix
          Command Line navigation, Git, IntelliJ
        </p>
      </section>

      <section class="location">
        <h1>Our Project</h1>
        <p>
          We have designed and created an interactive travel site, where a user
          can view landmarks from New York City, along with the ability to
          create custom itineraries. We have incorporated google maps through
          API calls for each landmark giving a pin location when a user selects
          the landmark.
        </p>
      </section>

      <!-- <section class="questions">
    <h1>More About Me</h1>
      <h2>What is important to you?</h2>
       <p>Aside from my family education is extremely important to me and has always been a huge component of my growth.</p>
      <h2>What are your favorite hobbies?</h2>
       <p>I enjoy playing Ice Hockey. I'm a huge wrestling fan and love attending Wrestle Mania. I also enjoy trying new Vegan foods and traveling.</p>
      <h2>What is your dream job?</h2>
       <p>I'd love to take my new freelance career and turn it into a fullt-time gig.</p>
      <h2>What music have you been listening to lately?</h2>
       <p>I've been listening to the Focus playlist on Spotify.</p>
</section> -->
    </body>





  </div>
</template>

<script>

export default {
 };
</script>

<style scoped>
body {
  color: #222222;
  font-size: 1em;
  font-family: "Open Sans", "Helvetica Neue", sans-serif;
  
}

.social-icons
{
  text-align:left;
 
}
.social-icons a
{
  width:40px;
  height:40px;
  line-height:40px;
  margin-left:6px;
  margin-right:0;
  border-radius:50%;
  background-color:#5e6479
}



.social-icons
{
  padding-left:0;
  margin-bottom:0;
  list-style:none
}
.social-icons li
{
  display:inline-block;
  margin-bottom:4px
}
.social-icons li.title
{
  margin-right:15px;
  text-transform:uppercase;
  color:#96a2b2;
  font-weight:700;
  font-size:13px
}
.social-icons a{
  background-color:#0078c7;
  color:#ffffff;
  font-size:16px;
  display:inline-block;
  line-height:44px;
  width:44px;
  height:44px;
  text-align:center;
  margin-right:8px;
  border-radius:100%;
  -webkit-transition:all .2s linear;
  -o-transition:all .2s linear;
  transition:all .2s linear
}
.social-icons a:active,.social-icons a:focus,.social-icons a:hover
{
  color:#fff;
  background-color:#0d0f11
}
.social-icons.size-sm a
{
  line-height:34px;
  height:34px;
  width:34px;
  font-size:14px
}

.social-icons a.linkedin:hover
{
  background-color:#253e49
}














.introduction > p,
.location > p,
.content-footer > p {
  font-weight: 300;
  letter-spacing: 0.05em;
}

.questions > h2 {
  font-family: "Gentium Book Basic", Georgia, serif;
  font-size: 1.2em;
  font-weight: bold;
}

/* -------------------------
      Link Styles
   -------------------------*/

a {
  font-weight: bold;
  text-decoration: none;
  /*color: #a1a1a1;*/
  color: #f1f1f1;
}

a:visited {
  color: #f1f1f1;
}

/* -------------------------
      Global Styles
   -------------------------*/

.starcontainer h2 {
  font-size: 2.8em;
  margin-bottom: 0.2em;
  /* background-color:#27901d3d; */
}

.starcontainerportfolio > h2 {
  text-align: center;
  font-size: 2.8em;
  margin-bottom: 0.2em;
}

.fa-star {
  margin-bottom: 0 auto;
}

hr {
  border: 2px solid #a1a1a1;
  width: 15.7em;
  margin-top: -1em;
  margin-bottom: 2em;
  background-color: white;
}

hr,
.fa-star {
  /* background-color:#27901d3d; */
  padding: 0 0.25em;
}

.starcontainer .fa {
  color: #a1a1a1;
}

.starcontainerportfolio .fa {
  color: #a1a1a1;
  display: inline-block;
}

/* -------------------------
      Layout Declarations
   -------------------------*/

.masthead-heading,
.masthead-intro,
.content-footer,
.starcontainer,
.starcontainerportfolio {
  text-align: center;
}

.masthead {
  background-image: url("https://unsplash.imgix.net/5/night-city.jpg?q=75&fm=jpg&s=17d530aa2cd2080b1aba21843cc5f433");
  background-repeat: no-repeat;
  border-top: solid 1em #a1a1a1;
  border-bottom: solid 1em #a1a1a1;
  background-size: cover;
  padding: 6em 0;
}

.masthead > img {
  max-height: 6em;
  border-radius: 150%;
  display: block;
  margin: 0 auto;
  border: 4px solid #a1a1a1;
}

.masthead-intro {
  margin-bottom: 0.1em;
  font-family: "Shadows Into Light", cursive;
  font-size: 2em;
}

.masthead-heading {
  margin-top: -0.2em;
  font-family: "Shadows Into Light", cursive;
  font-weight: bold;
  font-size: 6em;
  letter-spacing: -0.02em;
  text-transform: uppercase;
}

.content-footer,
.introduction,
.location,
.questions {
  max-width: 38em;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2em;
}

.questions {
  padding-bottom: 1.5em;
}

/* -------------------------
    Portfolio
   -------------------------*/

li {
  list-style: none;
}

#container {
  background-color: grey;
  position: relative;
  width: 100%;
  overflow: hidden;
}
.box {
  float: left;
  width: 31%;
  margin: 1% 1% 93px 1%;
}

.box img {
  width: 100%;
  display: block;
  border-style: solid;
  border-width: 1.5px;
}

button {
  cursor: pointer;
  transition: all 0.3s;
}

.btn {
  background-color: #a1a1a1;
  border-color: #a1a1a1;
  border-style: none;
  border-radius: 0.3em;
  font-size: 1em;
  text-shadow: none;
  height: 3.3em;
  width: 9.6em;
  margin-left: 30%;
  margin-top: 5%;
}

.btn:hover {
  background-color: #282828;
}

/* -------------------------
        Footer
   -------------------------*/
.social {
  padding: 0;
  list-style: none;
}

section > h1 {
  margin-top: 2em;
}

.social > li {
  display: inline-block;
  padding-right: 1em;
}

.content-footer > p {
  color: white;
}

.content-footer > a {
  margin-right: 0.1em;
}

.content-footer {
  background-color: #282828;
  max-width: 100%;
  padding: 4em 0;
}

/* -------------------------
        Media query
   -------------------------*/

@media only screen and (max-width: 500px) {
  .img-responsive {
    /*margin-top: -1em;*/
  }
  .box:nth-child(1n + 2) {
    border-top: 3px solid #a1a1a1;
    padding-top: 3em;
  }
  .box {
    display: block;
    width: 75%;
    padding-left: 2em;
    padding-top: 0;
  }
  .content-footer {
    font-size: 0.8em;
  }
  .masthead {
    padding: 3em 0;
  }
  .masthead-heading {
    font-size: 3em;
  }
}


</style>