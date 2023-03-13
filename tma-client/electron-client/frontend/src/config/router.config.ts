/**
 * 基础路由
 * @type { *[] }
 */
import AppFrame from '@/layouts/AppFrame.vue'

export default [
  {
    path: '/',
    component: AppFrame,
    
    children: [
      {
        path: '',
        component: () => import('@/views/Tomato/MainPage.vue')
      },
      {
        path: 'tomato',
        name: 'Tomato',
        component: () => import('@/views/Tomato/MainPage.vue')
      }
    ]
  },
]