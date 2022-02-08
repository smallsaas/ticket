
// import React from 'react';
// import ZEle from 'zero-element';
// import config from './config/representation-edit';


// export default () => <ZEle namespace="representation-edit" config={config} />;

import React from 'react';
import ZEle from 'zero-element';
import config from './config/representation-edit';
import useBreadcrumb from '@/framework/useBreadcrumb';

export default function () {

    useBreadcrumb([
      { title: '首页' },
      { title: '申述管理', path: '/representation' },
      { title: '处理申述' }
    ]);
  
    return <div>
     <ZEle namespace="shenshuumanage-edit" config={config} />
    </div>
  }


// export default () => <ZEle namespace="representation-edit" config={config} />;
