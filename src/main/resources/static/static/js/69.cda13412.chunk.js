(this["webpackJsonpreact-demo"]=this["webpackJsonpreact-demo"]||[]).push([[69],{1059:function(t,n,e){"use strict";function r(t,n,e){return n in t?Object.defineProperty(t,n,{value:e,enumerable:!0,configurable:!0,writable:!0}):t[n]=e,t}var i=e(691),o=e(642),u=e(236),a=function(){function t(t){r(this,"_defaultDir",void 0),r(this,"_lastDir",void 0),t?o.isStrong(t)||u(!1):t=o.getGlobalDir(),this._defaultDir=t,this.reset()}var n=t.prototype;return n.reset=function(){this._lastDir=this._defaultDir},n.getDirection=function(t){return this._lastDir=i.getDirection(t,this._lastDir),this._lastDir},t}();t.exports=a},1065:function(t,n,e){"use strict";var r,i="Unknown",o=(new(e(1066))).getResult(),u=function(t){if(!t)return{major:"",minor:""};var n=t.split(".");return{major:n[0],minor:n[1]}}(o.browser.version),a={browserArchitecture:o.cpu.architecture||i,browserFullVersion:o.browser.version||i,browserMinorVersion:u.minor||i,browserName:o.browser.name||i,browserVersion:o.browser.major||i,deviceName:o.device.model||i,engineName:o.engine.name||i,engineVersion:o.engine.version||i,platformArchitecture:o.cpu.architecture||i,platformName:(r=o.os.name,{"Mac OS":"Mac OS X"}[r]||r||i),platformVersion:o.os.version||i,platformFullVersion:o.os.version||i};t.exports=a},1067:function(t,n,e){"use strict";var r=e(236),i=/\./,o=/\|\|/,u=/\s+\-\s+/,a=/^(<=|<|=|>=|~>|~|>|)?\s*(.+)/,c=/^(\d*)(.*)/;function s(t,n){if(""===(t=t.trim()))return!0;var e,r=n.split(i),o=h(t),u=o.modifier,a=o.rangeComponents;switch(u){case"<":return f(r,a);case"<=":return-1===(e=v(r,a))||0===e;case">=":return l(r,a);case">":return 1===v(r,a);case"~":case"~>":return function(t,n){var e=n.slice(),r=n.slice();1<r.length&&r.pop();var i=r.length-1,o=parseInt(r[i],10);return p(o)&&(r[i]=o+1+""),l(t,e)&&f(t,r)}(r,a);default:return 0===v(r,a)}}function f(t,n){return-1===v(t,n)}function l(t,n){var e=v(t,n);return 1===e||0===e}function h(t){var n=t.split(i),e=n[0].match(a);return e||r(!1),{modifier:e[1],rangeComponents:[e[2]].concat(n.slice(1))}}function p(t){return!isNaN(t)&&isFinite(t)}function d(t){return!h(t).modifier}function g(t,n){for(var e=t.length;e<n;e++)t[e]="0"}function m(t,n){return typeof t!=typeof n&&r(!1),n<t?1:t<n?-1:0}function v(t,n){for(var e,r,i,o,u,a,s=function(t,n){g(t=t.slice(),(n=n.slice()).length);for(var e=0;e<n.length;e++){var r=n[e].match(/^[x*]$/i);if(r&&(n[e]=t[e]="0","*"===r[0]&&e===n.length-1))for(var i=e;i<t.length;i++)t[i]="0"}return g(n,t.length),[t,n]}(t,n),f=s[0],l=s[1],h=0;h<l.length;h++){var d=(e=f[h],r=l[h],i=e.match(c)[1],o=r.match(c)[1],u=parseInt(i,10),a=parseInt(o,10),p(u)&&p(a)&&u!==a?m(u,a):m(e,r));if(d)return d}return 0}var y={contains:function(t,n){return function(t,n){var e=t.split(o);return 1<e.length?e.some((function(t){return y.contains(t,n)})):function(t,n){var e=t.split(u);if(0<e.length&&e.length<=2||r(!1),1===e.length)return s(e[0],n);var i=e[0],o=e[1];return d(i)&&d(o)||r(!1),s(">="+i,n)&&s("<="+o,n)}(t=e[0].trim(),n)}(t.trim(),n.trim())}};t.exports=y},1068:function(t,n,e){"use strict";var r=Object.prototype.hasOwnProperty;t.exports=function(t,n,e){if(!t)return null;var i={};for(var o in t)r.call(t,o)&&(i[o]=n.call(e,t[o],o,t));return i}},1069:function(t,n,e){"use strict";t.exports=function(t){var n={};return function(e){return n.hasOwnProperty(e)||(n[e]=t.call(this,e)),n[e]}}},1077:function(t,n,e){"use strict";var r=e(1078);t.exports=function(t){return r(t)&&3==t.nodeType}},1078:function(t,n,e){"use strict";t.exports=function(t){var n=(t?t.ownerDocument||t:document).defaultView||window;return!(!t||!("function"==typeof n.Node?t instanceof n.Node:"object"==typeof t&&"number"==typeof t.nodeType&&"string"==typeof t.nodeName))}},1079:function(t,n,e){"use strict";var r=e(1080),i=e(1081);function o(t){return null==t?t:String(t)}t.exports=function(t,n){var e;if(window.getComputedStyle&&(e=window.getComputedStyle(t,null)))return o(e.getPropertyValue(i(n)));if(document.defaultView&&document.defaultView.getComputedStyle){if(e=document.defaultView.getComputedStyle(t,null))return o(e.getPropertyValue(i(n)));if("display"===n)return"none"}return t.currentStyle?o("float"===n?t.currentStyle.cssFloat||t.currentStyle.styleFloat:t.currentStyle[r(n)]):o(t.style&&t.style[r(n)])}},1080:function(t,n,e){"use strict";var r=/-(.)/g;t.exports=function(t){return t.replace(r,(function(t,n){return n.toUpperCase()}))}},1081:function(t,n,e){"use strict";var r=/([A-Z])/g;t.exports=function(t){return t.replace(r,"-$1").toLowerCase()}},1082:function(t,n,e){"use strict";var r=e(694);t.exports=function(t){var n=t.ownerDocument.documentElement;if(!("getBoundingClientRect"in t&&r(n,t)))return{left:0,right:0,top:0,bottom:0};var e=t.getBoundingClientRect();return{left:Math.round(e.left)-n.clientLeft,right:Math.round(e.right)-n.clientLeft,top:Math.round(e.top)-n.clientTop,bottom:Math.round(e.bottom)-n.clientTop}}},1083:function(t,n,e){"use strict";var r="undefined"!=typeof navigator&&-1<navigator.userAgent.indexOf("AppleWebKit");t.exports=function(t){return(t=t||document).scrollingElement?t.scrollingElement:r||"CSS1Compat"!==t.compatMode?t.body:t.documentElement}},1084:function(t,n,e){"use strict";t.exports=function(t){return t.Window&&t instanceof t.Window?{x:t.pageXOffset||t.document.documentElement.scrollLeft,y:t.pageYOffset||t.document.documentElement.scrollTop}:{x:t.scrollLeft,y:t.scrollTop}}},1086:function(t,n,e){"use strict";t.exports=function(t){var n=t||"",e=arguments.length;if(1<e)for(var r=1;r<e;r++){var i=arguments[r];i&&(n=(n?n+" ":"")+i)}return n}},1088:function(t,n,e){"use strict";var r={isImage:function(t){return"image"===i(t)[0]},isJpeg:function(t){var n=i(t);return r.isImage(t)&&("jpeg"===n[1]||"pjpeg"===n[1])}};function i(t){return t.split("/")}t.exports=r},1089:function(t,n,e){"use strict";var r=e(236);t.exports=function(t){return!(n=t)||"object"!=typeof n&&"function"!=typeof n||!("length"in n)||"setInterval"in n||"number"==typeof n.nodeType||!(Array.isArray(n)||"callee"in n||"item"in n)?[t]:Array.isArray(t)?t.slice():function(t){var n=t.length;if((Array.isArray(t)||"object"!=typeof t&&"function"!=typeof t)&&r(!1),"number"!=typeof n&&r(!1),0===n||n-1 in t||r(!1),"function"==typeof t.callee&&r(!1),t.hasOwnProperty)try{return Array.prototype.slice.call(t)}catch(t){}for(var e=Array(n),i=0;i<n;i++)e[i]=t[i];return e}(t);var n}},1093:function(t,n,e){"use strict";(function(n){e(1094),t.exports=n.setImmediate}).call(this,e(52))},1110:function(t,n,e){"use strict";t.exports={getPunctuation:function(){return"[.,+*?$|#{}()'\\^\\-\\[\\]\\\\\\/!@%\"~=<>_:;\u30fb\u3001\u3002\u3008-\u3011\u3014-\u301f\uff1a-\uff1f\uff01-\uff0f\uff3b-\uff40\uff5b-\uff65\u2e2e\u061f\u066a-\u066c\u061b\u060c\u060d\ufd3e\ufd3f\u1801\u0964\u104a\u104b\u2010-\u2027\u2030-\u205e\xa1-\xb1\xb4-\xb8\xba\xbb\xbf]"}}},1120:function(t,n,e){"use strict";var r=function(){function t(t){var n,e;e=void 0,(n="_uri")in this?Object.defineProperty(this,n,{value:e,enumerable:!0,configurable:!0,writable:!0}):this[n]=e,this._uri=t}return t.prototype.toString=function(){return this._uri},t}();t.exports=r},1139:function(t,n,e){t.exports=function(){"use strict";function t(t,n){if(t)for(var e in t)({}).hasOwnProperty.call(t,e)&&n(e,t[e])}var n={unstyled:"p","header-one":"h1","header-two":"h2","header-three":"h3","header-four":"h4","header-five":"h5","header-six":"h6","unordered-list-item":"ul","ordered-list-item":"ol",blockquote:"blockquote",code:"pre"};function e(t){return t&&n[t]}function r(n){var e="";return t(n,(function(t,n){n&&(e+="".concat(t,":").concat(n,";"))})),e}function i(t,n){var e=[],r=0,i=t.entityRanges.map((function(t){return{offset:t.offset,length:t.length,key:t.key,type:"ENTITY"}}));return(i=(i=i.concat(function(t,n){var e=[];if(n)for(var r=0,i=0,o=t,u=n.trigger||"#",a=n.separator||" ";o.length>0&&i>=0;)if(o[0]===u?(i=0,r=0,o=o.substr(u.length)):(i=o.indexOf(a+u))>=0&&(o=o.substr(i+(a+u).length),r+=i+a.length),i>=0){var c=o.indexOf(a)>=0?o.indexOf(a):o.length,s=o.substr(0,c);s&&s.length>0&&e.push({offset:r,length:s.length+u.length,type:"HASHTAG"}),r+=u.length}return e}(t.text,n))).sort((function(t,n){return t.offset-n.offset}))).forEach((function(t){t.offset>r&&e.push({start:r,end:t.offset}),e.push({start:t.offset,end:t.offset+t.length,entityKey:t.key,type:t.type}),r=t.offset+t.length})),r<t.text.length&&e.push({start:r,end:t.text.length}),e}function o(t){return!(!(t.entityRanges.length>0)||!function(t){return void 0===t||null===t||0===t.length||0===t.trim().length}(t.text)&&"atomic"!==t.type)}function u(t,n){var e={};return t.COLOR[n]&&(e.COLOR=t.COLOR[n]),t.BGCOLOR[n]&&(e.BGCOLOR=t.BGCOLOR[n]),t.FONTSIZE[n]&&(e.FONTSIZE=t.FONTSIZE[n]),t.FONTFAMILY[n]&&(e.FONTFAMILY=t.FONTFAMILY[n]),t.UNDERLINE[n]&&(e.UNDERLINE=!0),t.ITALIC[n]&&(e.ITALIC=!0),t.BOLD[n]&&(e.BOLD=!0),t.STRIKETHROUGH[n]&&(e.STRIKETHROUGH=!0),t.CODE[n]&&(e.CODE=!0),t.SUBSCRIPT[n]&&(e.SUBSCRIPT=!0),t.SUPERSCRIPT[n]&&(e.SUPERSCRIPT=!0),e}function a(t,n,e){var r=!0;return e>0&&e<t.length?n.forEach((function(n){r=r&&t[n][e]===t[n][e-1]})):r=!1,r}function c(t,n,e,r){var i=t[n];if("function"===typeof r){var o=r(i,e);if(o)return o}if("MENTION"===i.type)return'<a href="'.concat(i.data.url,'" class="wysiwyg-mention" data-mention data-value="').concat(i.data.value,'">').concat(e,"</a>");if("LINK"===i.type){var u=i.data.targetOption||"_self";return'<a href="'.concat(i.data.url,'" target="').concat(u,'">').concat(e,"</a>")}if("IMAGE"===i.type){var a=i.data.alignment;return a&&a.length?'<div style="text-align:'.concat(a,';"><img src="').concat(i.data.src,'" alt="').concat(i.data.alt,'" style="height: ').concat(i.data.height,";width: ").concat(i.data.width,'"/></div>'):'<img src="'.concat(i.data.src,'" alt="').concat(i.data.alt,'" style="height: ').concat(i.data.height,";width: ").concat(i.data.width,'"/>')}return"EMBEDDED_LINK"===i.type?'<iframe width="'.concat(i.data.width,'" height="').concat(i.data.height,'" src="').concat(i.data.src,'" frameBorder="0"></iframe>'):e}function s(t,n,e,r){var i=[],o=Array.from(t.text);if(o.length>0)for(var c,s=function(t){var n=t.text,e=t.inlineStyleRanges,r={BOLD:new Array(n.length),ITALIC:new Array(n.length),UNDERLINE:new Array(n.length),STRIKETHROUGH:new Array(n.length),CODE:new Array(n.length),SUPERSCRIPT:new Array(n.length),SUBSCRIPT:new Array(n.length),COLOR:new Array(n.length),BGCOLOR:new Array(n.length),FONTSIZE:new Array(n.length),FONTFAMILY:new Array(n.length),length:n.length};return e&&e.length>0&&e.forEach((function(t){for(var n=t.offset,e=n+t.length,i=n;i<e;i+=1)0===t.style.indexOf("color-")?r.COLOR[i]=t.style.substring(6):0===t.style.indexOf("bgcolor-")?r.BGCOLOR[i]=t.style.substring(8):0===t.style.indexOf("fontsize-")?r.FONTSIZE[i]=t.style.substring(9):0===t.style.indexOf("fontfamily-")?r.FONTFAMILY[i]=t.style.substring(11):r[t.style]&&(r[t.style][i]=!0)})),r}(t),f=e;f<r;f+=1)f!==e&&a(s,n,f)?(c.text.push(o[f]),c.end=f+1):(c={styles:u(s,f),text:[o[f]],start:f,end:f+1},i.push(c));return i}function f(n,e){var r=s(n,["BOLD","ITALIC","UNDERLINE","STRIKETHROUGH","CODE","SUPERSCRIPT","SUBSCRIPT"],e.start,e.end),i="";return r.forEach((function(n){i+=function(n){var e=n.styles,r=function(t){return t&&t.length>0?t.map((function(t){switch(t){case"\n":return"<br>";case"&":return"&amp;";case"<":return"&lt;";case">":return"&gt;";default:return t}})).join(""):""}(n.text);return t(e,(function(t,n){r=function(t,n){return"BOLD"===t?"<strong>".concat(n,"</strong>"):"ITALIC"===t?"<em>".concat(n,"</em>"):"UNDERLINE"===t?"<ins>".concat(n,"</ins>"):"STRIKETHROUGH"===t?"<del>".concat(n,"</del>"):"CODE"===t?"<code>".concat(n,"</code>"):"SUPERSCRIPT"===t?"<sup>".concat(n,"</sup>"):"SUBSCRIPT"===t?"<sub>".concat(n,"</sub>"):n}(t,r)})),r}(n)})),i=function(t,n){if(t&&(t.COLOR||t.BGCOLOR||t.FONTSIZE||t.FONTFAMILY)){var e='style="';return t.COLOR&&(e+="color: ".concat(t.COLOR,";")),t.BGCOLOR&&(e+="background-color: ".concat(t.BGCOLOR,";")),t.FONTSIZE&&(e+="font-size: ".concat(t.FONTSIZE).concat(/^\d+$/.test(t.FONTSIZE)?"px":"",";")),t.FONTFAMILY&&(e+="font-family: ".concat(t.FONTFAMILY,";")),"<span ".concat(e+='"',">").concat(n,"</span>")}return n}(e.styles,i)}function l(t,n,e,r){var o=[],u=i(t,e);return u.forEach((function(e,i){var a=function(t,n,e,r){var i=[];s(t,["COLOR","BGCOLOR","FONTSIZE","FONTFAMILY"],e.start,e.end).forEach((function(n){i.push(f(t,n))}));var o=i.join("");return"ENTITY"===e.type?void 0!==e.entityKey&&null!==e.entityKey&&(o=c(n,e.entityKey,o,r)):"HASHTAG"===e.type&&(o='<a href="'.concat(o,'" class="wysiwyg-hashtag">').concat(o,"</a>")),o}(t,n,e,r);0===i&&(a=function(t){if(t){for(var n=t,e=0;e<n.length&&" "===t[e];e+=1)n=n.replace(" ","&nbsp;");return n}return t}(a)),i===u.length-1&&(a=function(t){if(t){for(var n=t,e=n.length-1;e>=0&&" "===n[e];e-=1)n="".concat(n.substring(0,e),"&nbsp;").concat(n.substring(e+1));return n}return t}(a)),o.push(a)})),o.join("")}function h(t,n,i,o,u){var a,c=[],s=[];return t.forEach((function(t){var f=!1;if(a?a.type!==t.type?(c.push("</".concat(e(a.type),">\n")),c.push("<".concat(e(t.type),">\n"))):a.depth===t.depth?s&&s.length>0&&(c.push(h(s,n,i,o,u)),s=[]):(f=!0,s.push(t)):c.push("<".concat(e(t.type),">\n")),!f){c.push("<li");var p=r(t.data);p&&c.push(' style="'.concat(p,'"')),o&&c.push(' dir = "auto"'),c.push(">"),c.push(l(t,n,i,u)),c.push("</li>\n"),a=t}})),s&&s.length>0&&c.push(h(s,n,i,o,u)),c.push("</".concat(e(a.type),">\n")),c.join("")}return function(t,n,i,u){var a=[];if(t){var s=t.blocks,f=t.entityMap;if(s&&s.length>0){var p=[];if(s.forEach((function(t){if(function(t){return"unordered-list-item"===t||"ordered-list-item"===t}(t.type))p.push(t);else{if(p.length>0){var s=h(p,f,n,u);a.push(s),p=[]}var d=function(t,n,i,u,a){var s=[];if(o(t))s.push(c(n,t.entityRanges[0].key,void 0,a));else{var f=e(t.type);if(f){s.push("<".concat(f));var h=r(t.data);h&&s.push(' style="'.concat(h,'"')),u&&s.push(' dir = "auto"'),s.push(">"),s.push(l(t,n,i,a)),s.push("</".concat(f,">"))}}return s.push("\n"),s.join("")}(t,f,n,i,u);a.push(d)}})),p.length>0){var d=h(p,f,n,i,u);a.push(d),p=[]}}}return a.join("")}}()},236:function(t,n,e){"use strict";var r=function(t){if(void 0===t)throw new Error("invariant(...): Second argument must be a string.")};t.exports=function(t,n){for(var e=arguments.length,i=new Array(2<e?e-2:0),o=2;o<e;o++)i[o-2]=arguments[o];if(r(n),!t){var u;if(void 0===n)u=new Error("Minified exception occurred; use the non-minified dev environment for the full error message and additional helpful warnings.");else{var a=0;(u=new Error(n.replace(/%s/g,(function(){return String(i[a++])})))).name="Invariant Violation"}throw u.framesToPop=1,u}}},304:function(t,n,e){"use strict";t.exports=function(t){if(null!=t)return t;throw new Error("Got unexpected null or undefined")}},313:function(t,n,e){"use strict";var r=e(1065),i=e(1067),o=e(1068),u=e(1069);function a(t,n,e,r){if(t===e)return!0;if(!e.startsWith(t))return!1;var o=e.slice(t.length);return!!n&&(o=r?r(o):o,i.contains(o,n))}function c(t){return"Windows"===r.platformName?t.replace(/^\s*NT/,""):t}var s={isBrowser:function(t){return a(r.browserName,r.browserFullVersion,t)},isBrowserArchitecture:function(t){return a(r.browserArchitecture,null,t)},isDevice:function(t){return a(r.deviceName,null,t)},isEngine:function(t){return a(r.engineName,r.engineVersion,t)},isPlatform:function(t){return a(r.platformName,r.platformFullVersion,t,c)},isPlatformArchitecture:function(t){return a(r.platformArchitecture,null,t)}};t.exports=o(s,u)},414:function(t,n,e){"use strict";t.exports={}},415:function(t,n,e){"use strict";t.exports=function(t,n,e,r,i,o,u,a){if(!t){var c;if(void 0===n)c=new Error("Minified exception occurred; use the non-minified dev environment for the full error message and additional helpful warnings.");else{var s=[e,r,i,o,u,a],f=0;(c=new Error(n.replace(/%s/g,(function(){return s[f++]})))).name="Invariant Violation"}throw c.framesToPop=1,c}}},591:function(t,n,e){"use strict";function r(t){return t.replace(/\//g,"-")}t.exports=function(t){return"object"==typeof t?Object.keys(t).filter((function(n){return t[n]})).map(r).join(" "):Array.prototype.map.call(arguments,r).join(" ")}},593:function(t,n,e){"use strict";var r=e(236),i=/[\uD800-\uDFFF]/;function o(t){return 55296<=t&&t<=57343}function u(t){return i.test(t)}function a(t,n){return 1+o(t.charCodeAt(n))}function c(t,n,e){if(n=n||0,e=void 0===e?1/0:e||0,!u(t))return t.substr(n,e);var r=t.length;if(r<=0||r<n||e<=0)return"";var i=0;if(0<n){for(;0<n&&i<r;n--)i+=a(t,i);if(r<=i)return""}else if(n<0){for(i=r;n<0&&0<i;n++)i-=a(t,i-1);i<0&&(i=0)}var o=r;if(e<r)for(o=i;0<e&&o<r;e--)o+=a(t,o);return t.substring(i,o)}var s={getCodePoints:function(t){for(var n=[],e=0;e<t.length;e+=a(t,e))n.push(t.codePointAt(e));return n},getUTF16Length:a,hasSurrogateUnit:u,isCodeUnitInSurrogateRange:o,isSurrogatePair:function(t,n){if(0<=n&&n<t.length||r(!1),n+1===t.length)return!1;var e=t.charCodeAt(n),i=t.charCodeAt(n+1);return 55296<=e&&e<=56319&&56320<=i&&i<=57343},strlen:function(t){if(!u(t))return t.length;for(var n=0,e=0;e<t.length;e+=a(t,e))n++;return n},substring:function(t,n,e){(n=n||0)<0&&(n=0),(e=void 0===e?1/0:e||0)<0&&(e=0);var r=Math.abs(e-n);return c(t,n=n<e?n:e,r)},substr:c};t.exports=s},642:function(t,n,e){"use strict";var r=e(236),i="LTR",o=null;function u(t){return t===i||"RTL"===t}function a(t){return u(t)||r(!1),t===i?"ltr":"rtl"}function c(t){o=t}var s={NEUTRAL:"NEUTRAL",LTR:i,RTL:"RTL",isStrong:u,getHTMLDir:a,getHTMLDirIfDifferent:function(t,n){return u(t)||r(!1),u(n)||r(!1),t===n?null:a(t)},setGlobalDir:c,initGlobalDir:function(){c(i)},getGlobalDir:function(){return o||this.initGlobalDir(),o||r(!1),o}};t.exports=s},645:function(t,n,e){"use strict";t.exports={BACKSPACE:8,TAB:9,RETURN:13,ALT:18,ESC:27,SPACE:32,PAGE_UP:33,PAGE_DOWN:34,END:35,HOME:36,LEFT:37,UP:38,RIGHT:39,DOWN:40,DELETE:46,COMMA:188,PERIOD:190,A:65,Z:90,ZERO:48,NUMPAD_0:96,NUMPAD_9:105}},646:function(t,n,e){"use strict";function r(t,n){var e=i.get(t,n);return"auto"===e||"scroll"===e}var i={get:e(1079),getScrollParent:function(t){if(!t)return null;for(var n=t.ownerDocument;t&&t!==n.body;){if(r(t,"overflow")||r(t,"overflowY")||r(t,"overflowX"))return t;t=t.parentNode}return n.defaultView||n.parentWindow}};t.exports=i},647:function(t,n,e){"use strict";var r=e(1083),i=e(1084);t.exports=function(t){var n=r(t.ownerDocument||t.document);t.Window&&t instanceof t.Window&&(t=n);var e=i(t),o=t===n?t.ownerDocument.documentElement:t,u=t.scrollWidth-o.clientWidth,a=t.scrollHeight-o.clientHeight;return e.x=Math.max(0,Math.min(e.x,u)),e.y=Math.max(0,Math.min(e.y,a)),e}},691:function(t,n,e){"use strict";var r=e(642),i=e(236),o="\u0590\u05be\u05c0\u05c3\u05c6\u05c8-\u05cf\u05d0-\u05ea\u05eb-\u05ef\u05f0-\u05f2\u05f3-\u05f4\u05f5-\u05ff\u07c0-\u07c9\u07ca-\u07ea\u07f4-\u07f5\u07fa\u07fb-\u07ff\u0800-\u0815\u081a\u0824\u0828\u082e-\u082f\u0830-\u083e\u083f\u0840-\u0858\u085c-\u085d\u085e\u085f-\u089f\u200f\ufb1d\ufb1f-\ufb28\ufb2a-\ufb36\ufb37\ufb38-\ufb3c\ufb3d\ufb3e\ufb3f\ufb40-\ufb41\ufb42\ufb43-\ufb44\ufb45\ufb46-\ufb4f",u="\u0608\u060b\u060d\u061b\u061c\u061d\u061e-\u061f\u0620-\u063f\u0640\u0641-\u064a\u066d\u066e-\u066f\u0671-\u06d3\u06d4\u06d5\u06e5-\u06e6\u06ee-\u06ef\u06fa-\u06fc\u06fd-\u06fe\u06ff\u0700-\u070d\u070e\u070f\u0710\u0712-\u072f\u074b-\u074c\u074d-\u07a5\u07b1\u07b2-\u07bf\u08a0-\u08b2\u08b3-\u08e3\ufb50-\ufbb1\ufbb2-\ufbc1\ufbc2-\ufbd2\ufbd3-\ufd3d\ufd40-\ufd4f\ufd50-\ufd8f\ufd90-\ufd91\ufd92-\ufdc7\ufdc8-\ufdcf\ufdf0-\ufdfb\ufdfc\ufdfe-\ufdff\ufe70-\ufe74\ufe75\ufe76-\ufefc\ufefd-\ufefe",a=new RegExp("[A-Za-z\xaa\xb5\xba\xc0-\xd6\xd8-\xf6\xf8-\u01ba\u01bb\u01bc-\u01bf\u01c0-\u01c3\u01c4-\u0293\u0294\u0295-\u02af\u02b0-\u02b8\u02bb-\u02c1\u02d0-\u02d1\u02e0-\u02e4\u02ee\u0370-\u0373\u0376-\u0377\u037a\u037b-\u037d\u037f\u0386\u0388-\u038a\u038c\u038e-\u03a1\u03a3-\u03f5\u03f7-\u0481\u0482\u048a-\u052f\u0531-\u0556\u0559\u055a-\u055f\u0561-\u0587\u0589\u0903\u0904-\u0939\u093b\u093d\u093e-\u0940\u0949-\u094c\u094e-\u094f\u0950\u0958-\u0961\u0964-\u0965\u0966-\u096f\u0970\u0971\u0972-\u0980\u0982-\u0983\u0985-\u098c\u098f-\u0990\u0993-\u09a8\u09aa-\u09b0\u09b2\u09b6-\u09b9\u09bd\u09be-\u09c0\u09c7-\u09c8\u09cb-\u09cc\u09ce\u09d7\u09dc-\u09dd\u09df-\u09e1\u09e6-\u09ef\u09f0-\u09f1\u09f4-\u09f9\u09fa\u0a03\u0a05-\u0a0a\u0a0f-\u0a10\u0a13-\u0a28\u0a2a-\u0a30\u0a32-\u0a33\u0a35-\u0a36\u0a38-\u0a39\u0a3e-\u0a40\u0a59-\u0a5c\u0a5e\u0a66-\u0a6f\u0a72-\u0a74\u0a83\u0a85-\u0a8d\u0a8f-\u0a91\u0a93-\u0aa8\u0aaa-\u0ab0\u0ab2-\u0ab3\u0ab5-\u0ab9\u0abd\u0abe-\u0ac0\u0ac9\u0acb-\u0acc\u0ad0\u0ae0-\u0ae1\u0ae6-\u0aef\u0af0\u0b02-\u0b03\u0b05-\u0b0c\u0b0f-\u0b10\u0b13-\u0b28\u0b2a-\u0b30\u0b32-\u0b33\u0b35-\u0b39\u0b3d\u0b3e\u0b40\u0b47-\u0b48\u0b4b-\u0b4c\u0b57\u0b5c-\u0b5d\u0b5f-\u0b61\u0b66-\u0b6f\u0b70\u0b71\u0b72-\u0b77\u0b83\u0b85-\u0b8a\u0b8e-\u0b90\u0b92-\u0b95\u0b99-\u0b9a\u0b9c\u0b9e-\u0b9f\u0ba3-\u0ba4\u0ba8-\u0baa\u0bae-\u0bb9\u0bbe-\u0bbf\u0bc1-\u0bc2\u0bc6-\u0bc8\u0bca-\u0bcc\u0bd0\u0bd7\u0be6-\u0bef\u0bf0-\u0bf2\u0c01-\u0c03\u0c05-\u0c0c\u0c0e-\u0c10\u0c12-\u0c28\u0c2a-\u0c39\u0c3d\u0c41-\u0c44\u0c58-\u0c59\u0c60-\u0c61\u0c66-\u0c6f\u0c7f\u0c82-\u0c83\u0c85-\u0c8c\u0c8e-\u0c90\u0c92-\u0ca8\u0caa-\u0cb3\u0cb5-\u0cb9\u0cbd\u0cbe\u0cbf\u0cc0-\u0cc4\u0cc6\u0cc7-\u0cc8\u0cca-\u0ccb\u0cd5-\u0cd6\u0cde\u0ce0-\u0ce1\u0ce6-\u0cef\u0cf1-\u0cf2\u0d02-\u0d03\u0d05-\u0d0c\u0d0e-\u0d10\u0d12-\u0d3a\u0d3d\u0d3e-\u0d40\u0d46-\u0d48\u0d4a-\u0d4c\u0d4e\u0d57\u0d60-\u0d61\u0d66-\u0d6f\u0d70-\u0d75\u0d79\u0d7a-\u0d7f\u0d82-\u0d83\u0d85-\u0d96\u0d9a-\u0db1\u0db3-\u0dbb\u0dbd\u0dc0-\u0dc6\u0dcf-\u0dd1\u0dd8-\u0ddf\u0de6-\u0def\u0df2-\u0df3\u0df4\u0e01-\u0e30\u0e32-\u0e33\u0e40-\u0e45\u0e46\u0e4f\u0e50-\u0e59\u0e5a-\u0e5b\u0e81-\u0e82\u0e84\u0e87-\u0e88\u0e8a\u0e8d\u0e94-\u0e97\u0e99-\u0e9f\u0ea1-\u0ea3\u0ea5\u0ea7\u0eaa-\u0eab\u0ead-\u0eb0\u0eb2-\u0eb3\u0ebd\u0ec0-\u0ec4\u0ec6\u0ed0-\u0ed9\u0edc-\u0edf\u0f00\u0f01-\u0f03\u0f04-\u0f12\u0f13\u0f14\u0f15-\u0f17\u0f1a-\u0f1f\u0f20-\u0f29\u0f2a-\u0f33\u0f34\u0f36\u0f38\u0f3e-\u0f3f\u0f40-\u0f47\u0f49-\u0f6c\u0f7f\u0f85\u0f88-\u0f8c\u0fbe-\u0fc5\u0fc7-\u0fcc\u0fce-\u0fcf\u0fd0-\u0fd4\u0fd5-\u0fd8\u0fd9-\u0fda\u1000-\u102a\u102b-\u102c\u1031\u1038\u103b-\u103c\u103f\u1040-\u1049\u104a-\u104f\u1050-\u1055\u1056-\u1057\u105a-\u105d\u1061\u1062-\u1064\u1065-\u1066\u1067-\u106d\u106e-\u1070\u1075-\u1081\u1083-\u1084\u1087-\u108c\u108e\u108f\u1090-\u1099\u109a-\u109c\u109e-\u109f\u10a0-\u10c5\u10c7\u10cd\u10d0-\u10fa\u10fb\u10fc\u10fd-\u1248\u124a-\u124d\u1250-\u1256\u1258\u125a-\u125d\u1260-\u1288\u128a-\u128d\u1290-\u12b0\u12b2-\u12b5\u12b8-\u12be\u12c0\u12c2-\u12c5\u12c8-\u12d6\u12d8-\u1310\u1312-\u1315\u1318-\u135a\u1360-\u1368\u1369-\u137c\u1380-\u138f\u13a0-\u13f4\u1401-\u166c\u166d-\u166e\u166f-\u167f\u1681-\u169a\u16a0-\u16ea\u16eb-\u16ed\u16ee-\u16f0\u16f1-\u16f8\u1700-\u170c\u170e-\u1711\u1720-\u1731\u1735-\u1736\u1740-\u1751\u1760-\u176c\u176e-\u1770\u1780-\u17b3\u17b6\u17be-\u17c5\u17c7-\u17c8\u17d4-\u17d6\u17d7\u17d8-\u17da\u17dc\u17e0-\u17e9\u1810-\u1819\u1820-\u1842\u1843\u1844-\u1877\u1880-\u18a8\u18aa\u18b0-\u18f5\u1900-\u191e\u1923-\u1926\u1929-\u192b\u1930-\u1931\u1933-\u1938\u1946-\u194f\u1950-\u196d\u1970-\u1974\u1980-\u19ab\u19b0-\u19c0\u19c1-\u19c7\u19c8-\u19c9\u19d0-\u19d9\u19da\u1a00-\u1a16\u1a19-\u1a1a\u1a1e-\u1a1f\u1a20-\u1a54\u1a55\u1a57\u1a61\u1a63-\u1a64\u1a6d-\u1a72\u1a80-\u1a89\u1a90-\u1a99\u1aa0-\u1aa6\u1aa7\u1aa8-\u1aad\u1b04\u1b05-\u1b33\u1b35\u1b3b\u1b3d-\u1b41\u1b43-\u1b44\u1b45-\u1b4b\u1b50-\u1b59\u1b5a-\u1b60\u1b61-\u1b6a\u1b74-\u1b7c\u1b82\u1b83-\u1ba0\u1ba1\u1ba6-\u1ba7\u1baa\u1bae-\u1baf\u1bb0-\u1bb9\u1bba-\u1be5\u1be7\u1bea-\u1bec\u1bee\u1bf2-\u1bf3\u1bfc-\u1bff\u1c00-\u1c23\u1c24-\u1c2b\u1c34-\u1c35\u1c3b-\u1c3f\u1c40-\u1c49\u1c4d-\u1c4f\u1c50-\u1c59\u1c5a-\u1c77\u1c78-\u1c7d\u1c7e-\u1c7f\u1cc0-\u1cc7\u1cd3\u1ce1\u1ce9-\u1cec\u1cee-\u1cf1\u1cf2-\u1cf3\u1cf5-\u1cf6\u1d00-\u1d2b\u1d2c-\u1d6a\u1d6b-\u1d77\u1d78\u1d79-\u1d9a\u1d9b-\u1dbf\u1e00-\u1f15\u1f18-\u1f1d\u1f20-\u1f45\u1f48-\u1f4d\u1f50-\u1f57\u1f59\u1f5b\u1f5d\u1f5f-\u1f7d\u1f80-\u1fb4\u1fb6-\u1fbc\u1fbe\u1fc2-\u1fc4\u1fc6-\u1fcc\u1fd0-\u1fd3\u1fd6-\u1fdb\u1fe0-\u1fec\u1ff2-\u1ff4\u1ff6-\u1ffc\u200e\u2071\u207f\u2090-\u209c\u2102\u2107\u210a-\u2113\u2115\u2119-\u211d\u2124\u2126\u2128\u212a-\u212d\u212f-\u2134\u2135-\u2138\u2139\u213c-\u213f\u2145-\u2149\u214e\u214f\u2160-\u2182\u2183-\u2184\u2185-\u2188\u2336-\u237a\u2395\u249c-\u24e9\u26ac\u2800-\u28ff\u2c00-\u2c2e\u2c30-\u2c5e\u2c60-\u2c7b\u2c7c-\u2c7d\u2c7e-\u2ce4\u2ceb-\u2cee\u2cf2-\u2cf3\u2d00-\u2d25\u2d27\u2d2d\u2d30-\u2d67\u2d6f\u2d70\u2d80-\u2d96\u2da0-\u2da6\u2da8-\u2dae\u2db0-\u2db6\u2db8-\u2dbe\u2dc0-\u2dc6\u2dc8-\u2dce\u2dd0-\u2dd6\u2dd8-\u2dde\u3005\u3006\u3007\u3021-\u3029\u302e-\u302f\u3031-\u3035\u3038-\u303a\u303b\u303c\u3041-\u3096\u309d-\u309e\u309f\u30a1-\u30fa\u30fc-\u30fe\u30ff\u3105-\u312d\u3131-\u318e\u3190-\u3191\u3192-\u3195\u3196-\u319f\u31a0-\u31ba\u31f0-\u31ff\u3200-\u321c\u3220-\u3229\u322a-\u3247\u3248-\u324f\u3260-\u327b\u327f\u3280-\u3289\u328a-\u32b0\u32c0-\u32cb\u32d0-\u32fe\u3300-\u3376\u337b-\u33dd\u33e0-\u33fe\u3400-\u4db5\u4e00-\u9fcc\ua000-\ua014\ua015\ua016-\ua48c\ua4d0-\ua4f7\ua4f8-\ua4fd\ua4fe-\ua4ff\ua500-\ua60b\ua60c\ua610-\ua61f\ua620-\ua629\ua62a-\ua62b\ua640-\ua66d\ua66e\ua680-\ua69b\ua69c-\ua69d\ua6a0-\ua6e5\ua6e6-\ua6ef\ua6f2-\ua6f7\ua722-\ua76f\ua770\ua771-\ua787\ua789-\ua78a\ua78b-\ua78e\ua790-\ua7ad\ua7b0-\ua7b1\ua7f7\ua7f8-\ua7f9\ua7fa\ua7fb-\ua801\ua803-\ua805\ua807-\ua80a\ua80c-\ua822\ua823-\ua824\ua827\ua830-\ua835\ua836-\ua837\ua840-\ua873\ua880-\ua881\ua882-\ua8b3\ua8b4-\ua8c3\ua8ce-\ua8cf\ua8d0-\ua8d9\ua8f2-\ua8f7\ua8f8-\ua8fa\ua8fb\ua900-\ua909\ua90a-\ua925\ua92e-\ua92f\ua930-\ua946\ua952-\ua953\ua95f\ua960-\ua97c\ua983\ua984-\ua9b2\ua9b4-\ua9b5\ua9ba-\ua9bb\ua9bd-\ua9c0\ua9c1-\ua9cd\ua9cf\ua9d0-\ua9d9\ua9de-\ua9df\ua9e0-\ua9e4\ua9e6\ua9e7-\ua9ef\ua9f0-\ua9f9\ua9fa-\ua9fe\uaa00-\uaa28\uaa2f-\uaa30\uaa33-\uaa34\uaa40-\uaa42\uaa44-\uaa4b\uaa4d\uaa50-\uaa59\uaa5c-\uaa5f\uaa60-\uaa6f\uaa70\uaa71-\uaa76\uaa77-\uaa79\uaa7a\uaa7b\uaa7d\uaa7e-\uaaaf\uaab1\uaab5-\uaab6\uaab9-\uaabd\uaac0\uaac2\uaadb-\uaadc\uaadd\uaade-\uaadf\uaae0-\uaaea\uaaeb\uaaee-\uaaef\uaaf0-\uaaf1\uaaf2\uaaf3-\uaaf4\uaaf5\uab01-\uab06\uab09-\uab0e\uab11-\uab16\uab20-\uab26\uab28-\uab2e\uab30-\uab5a\uab5b\uab5c-\uab5f\uab64-\uab65\uabc0-\uabe2\uabe3-\uabe4\uabe6-\uabe7\uabe9-\uabea\uabeb\uabec\uabf0-\uabf9\uac00-\ud7a3\ud7b0-\ud7c6\ud7cb-\ud7fb\ue000-\uf8ff\uf900-\ufa6d\ufa70-\ufad9\ufb00-\ufb06\ufb13-\ufb17\uff21-\uff3a\uff41-\uff5a\uff66-\uff6f\uff70\uff71-\uff9d\uff9e-\uff9f\uffa0-\uffbe\uffc2-\uffc7\uffca-\uffcf\uffd2-\uffd7\uffda-\uffdc"+o+u+"]"),c=new RegExp("["+o+u+"]");function s(t){var n=a.exec(t);return null==n?null:n[0]}function f(t){var n=s(t);return null==n?r.NEUTRAL:c.exec(n)?r.RTL:r.LTR}function l(t,n){if(n=n||r.NEUTRAL,!t.length)return n;var e=f(t);return e===r.NEUTRAL?n:e}function h(t,n){return n=n||r.getGlobalDir(),r.isStrong(n)||i(!1),l(t,n)}var p={firstStrongChar:s,firstStrongCharDir:f,resolveBlockDir:l,getDirection:h,isDirectionLTR:function(t,n){return h(t,n)===r.LTR},isDirectionRTL:function(t,n){return h(t,n)===r.RTL}};t.exports=p},694:function(t,n,e){"use strict";var r=e(1077);t.exports=function t(n,e){return!(!n||!e)&&(n===e||!r(n)&&(r(e)?t(n,e.parentNode):"contains"in n?n.contains(e):!!n.compareDocumentPosition&&!!(16&n.compareDocumentPosition(e))))}},695:function(t,n,e){"use strict";function r(t,n){return n&&(t===n.documentElement||t===n.body)}var i={getTop:function(t){var n=t.ownerDocument;return r(t,n)?n.body.scrollTop||n.documentElement.scrollTop:t.scrollTop},setTop:function(t,n){var e=t.ownerDocument;r(t,e)?e.body.scrollTop=e.documentElement.scrollTop=n:t.scrollTop=n},getLeft:function(t){var n=t.ownerDocument;return r(t,n)?n.body.scrollLeft||n.documentElement.scrollLeft:t.scrollLeft},setLeft:function(t,n){var e=t.ownerDocument;r(t,e)?e.body.scrollLeft=e.documentElement.scrollLeft=n:t.scrollLeft=n}};t.exports=i},697:function(t,n,e){"use strict";var r=e(793);t.exports=r},788:function(t,n,e){"use strict";t.exports=function(n){if(void 0===(n=n||("undefined"!=typeof document?document:void 0)))return null;try{return n.activeElement||n.body}catch(t){return n.body}}},789:function(t,n,e){"use strict";var r=e(1082);t.exports=function(t){var n=r(t);return{x:n.left,y:n.top,width:n.right-n.left,height:n.bottom-n.top}}},790:function(t,n,e){"use strict";function r(){var t;return document.documentElement&&(t=document.documentElement.clientWidth),!t&&document.body&&(t=document.body.clientWidth),t||0}function i(){var t;return document.documentElement&&(t=document.documentElement.clientHeight),!t&&document.body&&(t=document.body.clientHeight),t||0}function o(){return{width:window.innerWidth||r(),height:window.innerHeight||i()}}o.withoutScrollbars=function(){return{width:r(),height:i()}},t.exports=o},792:function(t,n,e){"use strict";var r=e(1088),i=e(1089),o=e(793),u=new RegExp("\r\n","g"),a={"text/rtf":1,"text/html":1};function c(t){if("file"==t.kind)return t.getAsFile()}var s=function(){function t(t){this.data=t,this.types=t.types?i(t.types):[]}var n=t.prototype;return n.isRichText=function(){return!(!this.getHTML()||!this.getText())||!this.isImage()&&this.types.some((function(t){return a[t]}))},n.getText=function(){var t;return this.data.getData&&(this.types.length?-1!=this.types.indexOf("text/plain")&&(t=this.data.getData("text/plain")):t=this.data.getData("Text")),t?t.replace(u,"\n"):null},n.getHTML=function(){if(this.data.getData){if(!this.types.length)return this.data.getData("Text");if(-1!=this.types.indexOf("text/html"))return this.data.getData("text/html")}},n.isLink=function(){return this.types.some((function(t){return-1!=t.indexOf("Url")||-1!=t.indexOf("text/uri-list")||t.indexOf("text/x-moz-url")}))},n.getLink=function(){return this.data.getData?-1==this.types.indexOf("text/x-moz-url")?-1!=this.types.indexOf("text/uri-list")?this.data.getData("text/uri-list"):this.data.getData("url"):this.data.getData("text/x-moz-url").split("\n")[0]:null},n.isImage=function(){if(this.types.some((function(t){return-1!=t.indexOf("application/x-moz-file")})))return!0;for(var t=this.getFiles(),n=0;n<t.length;n++){var e=t[n].type;if(!r.isImage(e))return!1}return!0},n.getCount=function(){return this.data.hasOwnProperty("items")?this.data.items.length:this.data.hasOwnProperty("mozItemCount")?this.data.mozItemCount:this.data.files?this.data.files.length:null},n.getFiles=function(){return this.data.items?Array.prototype.slice.call(this.data.items).map(c).filter(o.thatReturnsArgument):this.data.files?Array.prototype.slice.call(this.data.files):[]},n.hasFiles=function(){return 0<this.getFiles().length},t}();t.exports=s},793:function(t,n,e){"use strict";function r(t){return function(){return t}}function i(){}i.thatReturns=r,i.thatReturnsFalse=r(!1),i.thatReturnsTrue=r(!0),i.thatReturnsNull=r(null),i.thatReturnsThis=function(){return this},i.thatReturnsArgument=function(t){return t},t.exports=i}}]);