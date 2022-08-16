 <template>
  <div id="land">
    <div class="container">
      <h1 class="name">New York City Tour</h1>
      <p class="par">Travel through a city that never sleeps</p>
    </div>
    <button class="btn">Get Started</button>
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

.btn {
  margin-left: 25em;
  color: blue;
  
}

.btn:hover {
  background-color: rgb(23, 36, 59);
}
</style>