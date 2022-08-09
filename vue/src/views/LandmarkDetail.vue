<template>
  <div>
    <p>{{landmark.landmark_name}}</p>
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
    }
  


}
</script>

<style>

</style>