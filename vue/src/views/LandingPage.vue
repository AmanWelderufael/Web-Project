 <template>
  <div id="land">
    <div class="container">
      <h1 class="name">New York City Tour</h1>
      <p class="par">Travel through a city that never sleeps</p>
    </div>
    <router-link v-bind:to="{
            name: 'home'
          }" class="btn">Get Started</router-link>
  </div>
</template>
 
 <script>
export default {};
</script>
 
 <style scoped>
#land {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  background-image: url("../assets/26.jpg");
  background-size: cover;
  background-position: center center;
  display: flex;
  width: 100%;
  height: 100vh;
  justify-content: flex-start;
  align-items: center;
}
.container{
  margin-left: 10em;
}

.name {
  font-size: 20px;
  text-align: center;
}
.par {
  text-align: center;
}

/* .btn {
  margin-left: 25em;
  color: white;
  
}

.btn:hover {
  background-color: rgb(23, 36, 59);
} */
.btn {
  margin-left: 15%;

  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

</style>