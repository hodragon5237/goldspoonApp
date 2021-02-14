<template>
    <header class="header-global">
        <base-nav class="navbar-main" transparent type="" effect="light" expand>
            
            <!-- 메뉴 layout -->
            <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
                <base-dropdown tag="li" class="nav-item">
                    <a slot="title" class="nav-link" data-toggle="dropdown" role="button">
                        <i class="ni ni-collection d-lg-none"></i>
                        <span class="nav-link-inner--text">Examples</span>
                    </a>
                    <router-link to="/goldspoon" class="dropdown-item">금수저 테스트</router-link>
                </base-dropdown>
            </ul>
            <ul class="navbar-nav align-items-lg-center ml-lg-auto">
                <li class="nav-item d-none d-lg-block ml-lg-4">
                    <span class="nav-link-inner--text">
                        <router-link to="/login" class="dropdown-item">로그인</router-link>
                    </span>
                </li>
                <li class="nav-item d-none d-lg-block ml-lg-4">
                    <span class="nav-link-inner--text">
                        <router-link to="/register" class="dropdown-item">회원가입</router-link>
                    </span>
                </li>
            </ul>
        </base-nav>
    </header>
</template>
<script>

import BaseNav from "@/components/Base/BaseNav";
import BaseDropdown from "@/components/Base/BaseDropdown";

export default {
  components: {
      BaseNav,
      BaseDropdown
  }
};
</script>
<style>
</style>