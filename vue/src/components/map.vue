<template>
  <div>
       <GmapMap
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

<style>



</style>