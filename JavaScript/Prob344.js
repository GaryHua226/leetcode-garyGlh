/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    let n1=version1.length(),n2=version2.length(),end=Math.max(n1,n2);
    for(let p1=0,p2=0;p1<end||p2<end;p1++,p2++){
        let v1=0,v2=0;
        while(p1<n1&&version1[p1]!='.')v1=v1*10+version1[p1++]-'0';            
        while(p2<n2&&version2[p2]!='.')v2=v2*10+version2[p2++]-'0';
        if(v1>v2)return 1;
        else if(v1<v2)return -1;
    }
    return 0;
};

compareVersion('1.0.1','1');