<template>
  <div>
       <GmapMap
      :center="{ lat: 40.748817, lng: -73.985428 }"
      :zoom="7"
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

}
</script>

<style>

</style>