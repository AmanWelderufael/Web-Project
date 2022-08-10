<template>
  <div>
       <GmapMap id="map"
      :center="coordinates"
      :zoom="16"
      map-type-id="terrain"
      style="width: 500px; height: 600px"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in landmark"
        :position="m.position"
        :clickable="true"
        :draggable="true"
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


>>>>>>> 6ae5fe2439baa0e835df97a04f679794fa613ca6
</style>