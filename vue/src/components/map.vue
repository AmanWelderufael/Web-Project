<template>
  <div class="movie_card" id="bright">
       <GmapMap id="map"
      :center="coordinates"
      :zoom="16"
      map-type-id="terrain"
     
    >
      <GmapMarker
        :position="coordinates"
        :clickable="true"
        :draggable="false"
        @click="center = m.position"
      />
    </GmapMap>
   
  </div>
</template>

<script>
export default {
  
  props: {
    landmark: Object,
  },
  name: 'the-map',
  data() {
    return {
      coordinates:{
        lat: '',
        lng: ''
      
      }
    };
  },
  created(){
    this.coordinates.lat = this.landmark.latitude;
    this.coordinates.lng = this.landmark.longitude;
    this.coordinates.label = this.landmark.landmark_name;
  },
  methods:{
    getCoordinates(){
      let object = {
        lat: this.landmark.latitude,
        lng: this.landmark.longitude
      }
      return object;

      
    }
  }
}
</script>

<style scoped>
.movie_card {
   
    position: relative;
  display: block;
  width: 800px;
  height: 350px;
  margin: 80px auto;
  overflow: hidden;
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow: 0px 0px 120px -25px rgba(0, 0, 0, 0.5);
   
}
#map {
  width: 100%;
  height: 100%;
}



</style>