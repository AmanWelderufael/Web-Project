<template>
  <div id ="gridContainer">
    
    <p id = "name">{{landmark.landmark_name}}</p>
    <p id = "description">{{landmark.landmark_description}}</p>
    <img id="landmark-picture" :src="getImageURL(landmark.landmark_id)" />
    <img id="map" src='../assets/map.jpg'/>

  </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService'
export default {
    name: "landmark-details",
   
    data(){
      return{
        landmark: ''
      }
      
    },
    created(){
      LandmarkService.getByID(this.$route.params.id).then(response =>{
        this.landmark = response.data;
      })
    },
    methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    },
  },
    
  


}
</script>

<style>
#name{
  grid-area: name;
}
#description{
  grid-area: description;
}
#landmark-picture{
  grid-area: picture;
  width: 100%;
  height: 100%;

}
#map{
  grid-area: map;
  width: 100%;
}

#gridContainer{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "picture name map"
                        "picture description map"
                        "picture description map";
}

</style>