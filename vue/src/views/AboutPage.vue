<template>
  <div>
      <body>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> 
  <link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light|Raleway' rel='stylesheet' type='text/css'>
    
  


<section class="introduction">
  <div class="starcontainer">
    <h2>About me</h2>
    <i class="fa fa-star fa-2x"></i>
    <i class="star"></i>
  </div>
    <p>I am a Front End developer who believes in making the internet a better place. I currently work at Picspotr as a Web Developer/Design intern, Vice President of LatinosinHigherEd, and a freelancer in The Greater New Haven Area. Yes I wear many hats. </p>

    <p>It is my passion to conceptualize, develop, and deploy ideas to this great environment we call the internet. I am an advocate for Higher Education advancement and when I set my goals I sink my teeth into them. </p>
</section>

<section class="location">
    <h1>Where I’m From</h1>
    <p>I was born in the Bronx raised in Spanish Harlem and currently reside in Naugatuck CT.</p>
</section>

<section class="questions">
    <h1>More About Me</h1>
      <h2>What is important to you?</h2>
       <p>Aside from my family education is extremely important to me and has always been a huge component of my growth.</p>
      <h2>What are your favorite hobbies?</h2>
       <p>I enjoy playing Ice Hockey. I'm a huge wrestling fan and love attending Wrestle Mania. I also enjoy trying new Vegan foods and traveling.</p>
      <h2>What is your dream job?</h2>
       <p>I'd love to take my new freelance career and turn it into a fullt-time gig.</p>
      <h2>What music have you been listening to lately?</h2>
       <p>I've been listening to the Focus playlist on Spotify.</p>
</section>



</body>

  </div>
 
</template>

<script>
export default {};
</script>

<style scoped>

body {
  color: #222222;
  font-size: 1em;
  font-family: 'Open Sans', "Helvetica Neue", sans-serif;
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
  color: #F1F1F1;
}

a:visited {
  color: #F1F1F1;
}

/* -------------------------
      Global Styles
   -------------------------*/

.starcontainer h2 {
  font-size: 2.8em;
  margin-bottom: 0.2em;
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

hr, .fa-star {
  background-color: #fff;
  padding: 0 .25em
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
  font-family: 'Shadows Into Light', cursive;
  font-size: 2em;
}

.masthead-heading {
  margin-top: -0.2em;
  font-family: 'Shadows Into Light', cursive;
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
  float:left;
  width:31%;
  margin:1% 1% 93px 1%;
}

.box img {
  width: 100%;
  display: block;
  border-style: solid;
  border-width:1.5px;
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
    .box:nth-child(1n+2) {
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