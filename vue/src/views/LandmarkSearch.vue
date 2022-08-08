<template>
  <div>
      <div id="search">
        <label for="zip">Enter a Zip Code To Find exciting destinations!</label>
        <input type="text" name="zip" v-model="zipFilter"/>
      </div>
    <landmark-list v-bind:filteredList="filteredLandmarks"></landmark-list>




  </div>
</template>


<script>
import LandmarkList from '../components/LandmarkList.vue'
import LandmarkService from '../services/LandmarkService'
export default {
  components:{
    LandmarkList
  },
  name: "Landmark-search",
  data() {
    return {
      zipFilter: "",
      nameFilter: "",
      landmarks: [],
    };
  },
  computed: {
    filteredLandmarks() {
      return this.landmarks.filter((landmark) => {
        return this.zipFilter == "" ? true: this.zipFilter == landmark.address.zip;
      });
    },
  },
  created() {

    LandmarkService.search().then( response => {
       this.landmarks = response.data;
    })

  },
};
</script>

<style>
</style>