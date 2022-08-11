<template>
  <div>
       <GmapMap id="map"
      :center="coordinates"
      :zoom="16"
      map-type-id="terrain"
      style="width: 500px; height: 600px"
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

<<<<<<< HEAD
div{
  display: flex;
  align-content: space-around;
  justify-content: space-around;
  
}
#map{
  
width:100%;

max-height:100%;
}
=======


>>>>>>> 39dde5a94af1c86b56921c18c4fc90aa53b9d4a1
</style>