<template>
<div class="wrapper">
  <div class = "card">
    <img :src="getImageURL(landmark.landmark_id)">
    <div class = "info">
      <h1>{{landmark.landmark_name}} </h1>
      <p> {{landmark.landmark_description}} </p>
      <a href="#" class="btn">Add Itinerary</a>
      <a href="#" class="btn">Details</a>


    </div>
  </div>

</div>
  
         <!-- <img :src="getImageURL(landmark.landmark_id)">
      
      
          <h5 class = "card-title">{{landmark.landmark_name}}</h5>
          <p class = "card-text">{{landmark.landmark_description}}</p>
       -->



</template>






<script>

export default {

  

  props: {
    landmark: Object
  },

  methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    }
  }


}

</script>

<style scoped>
*{
  box-sizing: border-box;
  font-family: 'Lato', sans-serif;
}
html, body{
  width:100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #222;

}
.wrapper{
  display: flex;
  width: 70%;
  justify-content: space-around;

}
.card {
  width: 280px;
  height: 360px;
  padding: 2rem 1rem;
  background: #fff;
  position: relative;
  display: flex;
  align-items: flex-end;
  box-shadow: 0px 7px 10px rgba(0,0,0,0.5);
  transition: 0.5s ease-in-out;
}
.card:hover{
  transform: translateY(20px);
}
.card:before{
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, rgba(0,176,155,0.5), rgba(150,201,61,1));
  z-index: 2;
  transition: 0.5s all;
  opacity: 0;
}



img {
    float: left;
    width:  100px;
    height: 100px;
    object-fit: cover;
}
</style>