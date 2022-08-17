 <template>
  
    <div class="container">
      <div class="another-container">
      <h1 class="name">Start Your New York City Travels Here</h1>
      <div>
      <p class="par">Travel through a city that never sleeps</p>
      </div>
      <router-link v-bind:to="{
            name: 'home'
          }" class="btn">Plan your trip today!</router-link>

    </div>
    </div>
  
</template>
 
 <script>
export default {};
</script>
 
 <style scoped>
/* #land {
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
} */
.container{

  margin: auto;
   width: 100%;
  
  padding: 10px;
 box-sizing: border-box;
  background-image: url("../assets/26.jpg");
background-size: cover;
height: 100vh;
display: flex;
flex-direction: column;
align-content: center;
justify-content: center;
 /* margin: 0;
  padding: 0;
  box-sizing: border-box;
  background-image: url("../assets/26.jpg");
  background-size: cover;
  background-position: center center;
  display: flex;
  width: 100%;
  height: 100vh;
  justify-content: flex-start;
  align-items: center; */

}

.name {
  font-size: 400%;
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
  margin-right: 20;
  margin-top: 25rem;

  background: #18034b;
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
  font-size: 30px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #022e6e;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

</style>